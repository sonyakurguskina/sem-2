package ru.itis.kurguskina.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.kurguskina.dto.CreateUserDto;

@Controller
public class HelloController {

    @GetMapping("")
    public String getIndexPage() {
        return "index";
    }

    @GetMapping("/sign_up")
    public String getSignUp(Model model) {
        model.addAttribute("user", new CreateUserDto());

        return "sign_up";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }
}
