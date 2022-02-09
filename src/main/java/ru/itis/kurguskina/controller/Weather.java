package ru.itis.kurguskina.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.kurguskina.service.WeatherHttpService;

import java.io.IOException;
import java.util.Optional;

@RestController
public class Weather {
    private WeatherHttpService weatherHttpService = new WeatherHttpService();

    @GetMapping("/result")
    public String hello(@RequestParam Optional<String> city) throws IOException {
        String result = weatherHttpService.get(city.orElse("Kazan"));
        if (result != null){
            return result;
        } else {
            return "not found";
        }

    }
}
