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
import ru.itis.kurguskina.model.Appeal;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.model.Weather;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AppealRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private AppealRepository appealRepository;

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

        Weather weather = new Weather();
        weather.setEmail("test@mail.ru");
        weather.setCity("Kazan");

        Weather weather2 = new Weather();
        weather2.setEmail("test2@mail.ru");
        weather2.setCity("Moscow");

        Appeal appeal = new Appeal();
        appeal.setDate("30.03.2022");
        appeal.setUser(user);
        appeal.setWeather(weather);

        Appeal appeal2 = new Appeal();
        appeal2.setDate("29.03.2022");
        appeal2.setUser(user2);
        appeal2.setWeather(weather2);

        testEntityManager.persistAndFlush(user);
        testEntityManager.persistAndFlush(user2);

        testEntityManager.persistAndFlush(weather);
        testEntityManager.persistAndFlush(weather2);

        testEntityManager.persistAndFlush(appeal);
        testEntityManager.persistAndFlush(appeal2);
    }

    @Test
    public void testGetAppealsByUserId() {
        List<Appeal> result = appealRepository.getAppealsByUserId(1);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetAppealsByWeatherCityIgnoreCase() {
        List<Appeal> result = appealRepository.getAppealsByWeatherCityIgnoreCase("Moscow");
        Assert.assertNotNull(result);
        Assert.assertEquals("29.03.2022", result.get(0).getDate());
    }
}
