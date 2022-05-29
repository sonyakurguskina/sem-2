package ru.itis.kurguskina;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.itis.kurguskina.controller.WeatherController;
import ru.itis.kurguskina.dto.WeatherDto;
import ru.itis.kurguskina.model.Weather;
import ru.itis.kurguskina.repository.AppealRepository;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.repository.WeatherRepository;
import ru.itis.kurguskina.service.AppealService;
import ru.itis.kurguskina.service.UserService;
import ru.itis.kurguskina.service.WeatherService;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherService weatherService;

    @MockBean
    private WeatherRepository weatherRepository;

    @MockBean
    private UserService userService;

    @MockBean
    private AppealService appealService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private AppealRepository appealRepository;

    @Before
    public void init() {
        Weather weather = new Weather();
        weather.setEmail("mail@mail.ru");
        weather.setCity("Kazan");

        Weather weather2 = new Weather();
        weather2.setEmail("mail@mail.ru");
        weather2.setCity("Moscow");

        given(weatherService.findAll()).willReturn(Arrays.asList(WeatherDto.fromModel(weather),
                WeatherDto.fromModel(weather2)));
        given(weatherService.getWeathersByCity("Kazan")).willReturn(Arrays.asList(WeatherDto.fromModel(weather2)));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/allWeather")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].city").value("Kazan"));
    }

    @Test
    public void testGetWeatherByCity() throws Exception {
        mockMvc.perform(get("/history/weather/Kazan")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city").value("Moscow"));
    }

}
