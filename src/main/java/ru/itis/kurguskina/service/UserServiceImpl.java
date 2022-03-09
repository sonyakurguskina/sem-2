package ru.itis.kurguskina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.kurguskina.dto.CreateUserDto;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.advice.Password;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User getByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        return user;
    }

    @Override
    public UserDto getById(Integer id) {
        User user = userRepository.findById(id).orElse(new User("ivan",
                "ootsal@mail.ru", "1"));
        return UserDto.fromModel(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(UserDto::fromModel).collect(Collectors.toList());
    }

    @Override
    public UserDto save(CreateUserDto user) {
        return UserDto.fromModel(userRepository.save(new User(user.getName(), user.getEmail(),
                encoder.encode(user.getPassword()))));
    }
}
