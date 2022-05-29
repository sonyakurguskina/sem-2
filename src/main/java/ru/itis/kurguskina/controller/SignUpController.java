package ru.itis.kurguskina.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.kurguskina.dto.SignUpForm;
import ru.itis.kurguskina.ru.itis.kurguskina.service.UserService;


import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @GetMapping("/signUp")
    public String getSignUpPage(Authentication authentication, Model model) {
        if (authentication != null) {
            return "redirect:/";
        }
        model.addAttribute("signUpForm", new SignUpForm());
        return "registration";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid SignUpForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("signUpForm", form);
            return "registration";
        }
        userService.signUp(form);
        return "redirect:/signIn";
    }

    @GetMapping(value="/confirm")
    public String accountVerified(@RequestParam(value="code") String confirmCode){
        userService.updateState(confirmCode);
        return "verified";
    }
}


