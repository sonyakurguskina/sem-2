package ru.itis.kurguskina.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.kurguskina.config.MailConfig;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.service.Impl.UserServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @MockBean
        private UserRepository userRepository;

        @MockBean
        private BCryptPasswordEncoder encoder;

        @MockBean
        private JavaMailSender javaMailSender;

        @MockBean
        private MailConfig mailConfig;


        @Bean
        public UserService userService() {
            return new UserServiceImpl(userRepository, encoder, javaMailSender, mailConfig);
        }
    }

    @Autowired
    private UserService userService;


    @Test
    public void testGetAll() {
        List<UserDto> result = userService.getAll();
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetByEmail() {
        User result = userService.getByEmail("test@mail.ru");
        Assert.assertNull(result);
    }

    @Test
    public void testGetById() {
        User result = userService.getById(1);
        Assert.assertNotNull(result);
        Assert.assertEquals("name", result.getName());
    }
}
