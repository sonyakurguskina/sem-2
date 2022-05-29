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
import ru.itis.kurguskina.controller.UserController;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.service.UserService;


import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void init() {
        User user = new User();
        user.setEmail("mail1@mail.ru");
        user.setName("Name");
        user.setPassword("nameTeat");
        user.setVerificationCode("123");

        User user2 = new User();
        user2.setEmail("mail2@mail.ru");
        user2.setName("Name");
        user2.setPassword("nameMail");
        user2.setVerificationCode("1234");

        User user3 = new User();
        user3.setEmail("mail3@mail.ru");
        user3.setName("Name");
        user3.setPassword("nameMail");
        user3.setVerificationCode("12345");

        given(userService.getAll()).willReturn(Arrays.asList(UserDto.fromModel(user)));
        given(userService.getById(3)).willReturn(UserDto.fromModel(user3));
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/user")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name").value("Ivan"));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get("/user/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Igor"));
    }

}
