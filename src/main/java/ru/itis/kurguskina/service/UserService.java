package ru.itis.kurguskina.service;

import ru.itis.kurguskina.dto.CreateUserDto;
import ru.itis.kurguskina.dto.SignUpForm;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.model.User;

import java.util.List;

public interface UserService {
    User getByEmail(String email);

    User getById(Integer id);

    List<UserDto> getAll();

    UserDto save(CreateUserDto user, String url);

    boolean verify(String verificationCode);

    void sendVerificationMail(String mail, String name, String code, String url);
    void updateState(String confirmCode);
}
