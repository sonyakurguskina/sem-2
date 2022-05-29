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
import ru.itis.kurguskina.controller.AppealController;
import ru.itis.kurguskina.dto.AppealDto;
import ru.itis.kurguskina.model.Appeal;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.model.Weather;
import ru.itis.kurguskina.repository.AppealRepository;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.service.AppealService;
import ru.itis.kurguskina.service.UserService;

import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(AppealController.class)
public class AppealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppealService appealService;

    @MockBean
    private AppealRepository appealRepository;

    @MockBean
    private UserService userService;

    @MockBean
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

        given(appealService.getAppealsByUserId(1)).willReturn(Arrays.asList(AppealDto.fromModel(appeal)));
        given(appealService.getAppealsByWeatherCity("Moscow")).willReturn(Arrays.asList(AppealDto.fromModel(appeal2)));
    }

    @Test
    public void testGetAppealsByUserId() throws Exception {
        mockMvc.perform(get("/appeals/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].date").value("30.03.2022"));
    }

    @Test
    public void testGetAppealsByCity() throws Exception {
        mockMvc.perform(get("/appeals/city/Moscow")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].date").value("29.03.2022"));
    }


}
