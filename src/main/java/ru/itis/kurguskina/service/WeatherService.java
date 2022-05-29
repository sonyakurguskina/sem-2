package ru.itis.kurguskina.service;

import ru.itis.kurguskina.dto.WeatherDto;
import ru.itis.kurguskina.model.Weather;

import java.util.List;

public interface WeatherService {
    List<WeatherDto> findAll();

    WeatherDto save(Weather weather);

    List<WeatherDto> getWeathersByCity(String city);
}
