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
import ru.itis.kurguskina.model.Weather;

import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class WeatherRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private WeatherRepository weatherRepository;

    @Before
    public void init() {
        Weather weather = new Weather();
        weather.setEmail("test@mail.ru");
        weather.setCity("Kazan");

        Weather weather2 = new Weather();
        weather2.setEmail("test2@mail.ru");
        weather2.setCity("Kazan");

        testEntityManager.persistAndFlush(weather);
        testEntityManager.persistAndFlush(weather2);
    }

    @Test
    public void testGetWeathersByCityIgnoreCase() {
        List<Weather> result = weatherRepository.getWeathersByCityIgnoreCase("Kazan");
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
    }
}
