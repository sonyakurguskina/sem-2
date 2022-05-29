package ru.itis.kurguskina.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.itis.kurguskina.dto.WeatherDto;
import ru.itis.kurguskina.repository.WeatherRepository;
import ru.itis.kurguskina.service.Impl.WeatherServiceImpl;

import java.util.List;

@RunWith(SpringRunner.class)
public class WeatherServiceTest {

    @TestConfiguration
    static class UserServiceTestContextConfiguration {

        @MockBean
        private WeatherRepository weatherRepository;

        @Bean
        public WeatherService WeatherService(WeatherRepository weatherRepository) {
            return new WeatherServiceImpl(weatherRepository);
        }
    }

    @Autowired
    private WeatherService weatherService;

    @Test
    public void testFindAll() {
        List<WeatherDto> result = weatherService.findAll();
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void testGetWeathersByCity() {
        List<WeatherDto> result = weatherService.getWeathersByCity("Moscow");
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }
}
