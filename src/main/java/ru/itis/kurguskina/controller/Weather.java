package ru.itis.kurguskina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.kurguskina.advice.ParseHelper;
import ru.itis.kurguskina.dto.UserDto;
import ru.itis.kurguskina.repository.UserRepository;
import ru.itis.kurguskina.repository.WeatherRepository;
import ru.itis.kurguskina.service.WeatherHttpService;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RestController
public class Weather {
    private WeatherHttpService weatherHttpService = new WeatherHttpService();
    private final UserRepository userRepository;
    private final WeatherRepository weatherRepository;
    private final static ParseHelper parseHelper = new ParseHelper();
//@Autowired
//private BCryptPasswordEncoder encoder;

    @Autowired
    public Weather(UserRepository userRepository, WeatherRepository weatherRepository) {
        this.userRepository = userRepository;
        this.weatherRepository = weatherRepository;
    }

    public Weather(String description, String humidity, String temp, String name, String userEmail, UserRepository userRepository, WeatherRepository weatherRepository) {
        this.userRepository = userRepository;
        this.weatherRepository = weatherRepository;
    }

    @GetMapping("/result")
    public String getWeather(@RequestParam Optional<String> city, @RequestParam Optional<String> email)
            throws IOException {
        String userEmail = email.orElse("null");
        UserDto userDto = userRepository.findByEmail(userEmail);

        if (userDto != null) {
            String result = weatherHttpService.get(city.orElse("Kazan"));

            if (result != null) {
                Map<String, String> params = parseHelper.parseJson(result);
                weatherRepository.save(new Weather(params.get("description"), params.get("humidity"),
                        params.get("temp"), params.get("name"), userEmail, userRepository, weatherRepository));

                return result;
            } else {
                return "not found";
            }
        } else {
            return "null";
        }

    }
}
