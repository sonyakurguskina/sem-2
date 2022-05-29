package ru.itis.kurguskina.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.kurguskina.model.User;


import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        User user = new User();
        user.setEmail("test@mail.ru");
        user.setName("Ivan");
        user.setPassword("testTEST");
        user.setVerificationCode("123");

        User user2 = new User();
        user2.setEmail("test2@mail.ru");
        user2.setName("Ivan");
        user2.setPassword("testTEST");
        user2.setVerificationCode("1234");

        User user3 = new User();
        user3.setEmail("test3@mail.ru");
        user3.setName("Igor");
        user3.setPassword("testTEST");
        user3.setVerificationCode("12345");

        testEntityManager.persistAndFlush(user);
        testEntityManager.persistAndFlush(user2);
        testEntityManager.persistAndFlush(user3);
    }

    @Test
    public void testGetUserByEmail() {
        User result = userRepository.getUserByEmail("test@mail.ru");
        Assert.assertNotNull(result);
        Assert.assertEquals("Ivan", result.getName());
    }

    @Test
    public void testFindAllByName() {
        List<User> result = userRepository.findAllByName("Ivan");
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
        Assert.assertEquals("Ivan", result.get(0).getName());
        Assert.assertEquals("Ivan", result.get(1).getName());
    }

    @Test
    public void testFindAll() {
        List<User> result = userRepository.findAll();
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }


    @Test
    public void testFindAllByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        List<User> result = userRepository.findAllByIds(ids);
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByVerificationCode() {
        User result = userRepository.findByVerificationCode("12345");
        Assert.assertNotNull(result);
        Assert.assertEquals("Igor", result.getName());
    }
}
