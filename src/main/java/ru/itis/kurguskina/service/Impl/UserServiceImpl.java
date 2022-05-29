package ru.itis.kurguskina.service.Impl;

import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import ru.itis.kurguskina.config.MailConfig;
import ru.itis.kurguskina.dto.CreateUserDto;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.helper.exceptions.AccountNotExistsException;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.service.UserService;
import ru.itis.kurguskina.utils.EmailUtil;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final JavaMailSender javaMailSender;
    private final MailConfig mailConfig;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder,
                           JavaMailSender javaMailSender, MailConfig mailConfig) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.javaMailSender = javaMailSender;
        this.mailConfig = mailConfig;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    private EmailUtil emailUtil;


    @Override
    public User getByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        return user;
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::fromModel).collect(Collectors.toList());
    }


    @Override
    public UserDto save(CreateUserDto user, String url) {
        String code = RandomString.make(64);
        sendVerificationMail(user.getEmail(), user.getName(), code, url);

        return UserDto.fromModel(userRepository.save(new User(user.getName(), user.getEmail(),
                encoder.encode(user.getPassword()), Collections.emptyList(), code)));
    }

    @Override
    public boolean verify(String verificationCode) {
        User user = userRepository.findByVerificationCode(verificationCode);

        if (user != null) {
            user.setConfirmCode(null);
            user.setEnabled(true);
            userRepository.save(user);

            return true;
        }

        return false;
    }

    @Override
    public void sendVerificationMail(String mail, String name, String code, String url) {
        String from = mailConfig.getFrom();
        String sender = mailConfig.getSender();
        String subject = mailConfig.getSubject();
        String content = mailConfig.getContent();


        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom(from, sender);

            helper.setTo(mail);
            helper.setSubject(subject);

            content = content.replace("{name}", name);
            content = content.replace("{url}", url + "/verification?code=" + code);

            helper.setText(content, true);
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateState(String confirmCode) {
        User user = userRepository.findAllByConfirmCode(confirmCode);
        if (user == null) {
            throw new AccountNotExistsException();
        }
        user.setState(User.State.CONFIRMED);
        userRepository.save(user);
    }
}