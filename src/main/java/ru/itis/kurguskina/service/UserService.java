package ru.itis.kurguskina.service;

import ru.itis.kurguskina.dto.CreateUserDto;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.model.User;

import java.util.List;

public interface UserService {
    User getByEmail(String email);

    UserDto getById(Integer id);

    List<UserDto> getAll();

    UserDto save(CreateUserDto createUserDto);
}
