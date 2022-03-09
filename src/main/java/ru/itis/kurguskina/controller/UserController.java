package ru.itis.kurguskina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.kurguskina.dto.CreateUserDto;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.service.UserService;

import javax.validation.Valid;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public UserDto createUser(@Valid @RequestBody CreateUserDto user) {
        return userService.save(user);
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute(name = "user") CreateUserDto userDto) {
        System.out.println(userDto);
        userService.save(userDto);

        return "sign_up_success";
    }

    @GetMapping("/error")
    public String getLoginFail() {
        return "login_fail";
    }
}