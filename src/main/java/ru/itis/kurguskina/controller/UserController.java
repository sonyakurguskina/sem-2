package ru.itis.kurguskina.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import ru.itis.kurguskina.dto.CreateUserDto;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.model.User;
import ru.itis.kurguskina.service.UserService;


import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Returns all users")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Users were get",
            content = {@Content(mediaType = "application/json")})})
    @GetMapping("/user")
    @ResponseBody
    public Iterable<UserDto> getAll() {
        return userService.getAll();
    }

    @Operation(summary = "Returns user by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Users was get by id",
            content = {@Content(mediaType = "application/json")})})
    @GetMapping("/user/{id}")
    @ResponseBody
    public User get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @Operation(summary = "Returns sign up success view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute(name = "user") CreateUserDto userDto, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.save(userDto, url);

        return "sign_up_success";
    }

    @Operation(summary = "Returns login fail view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/error")
    public String getLoginFail() {
        return "login_fail";
    }

    @Operation(summary = "Returns verification view")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "View was get",
            content = {@Content(mediaType = "text/html")})})
    @GetMapping("/verification")
    public String verify(@Param("code") String code) {

        if (userService.verify(code)) {
            return "verification_success";
        } else {
            return "verification_failed";
        }
    }
}