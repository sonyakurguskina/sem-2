package ru.itis.kurguskina.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.kurguskina.dto.WeatherDto;
import ru.itis.kurguskina.model.Weather;
import ru.itis.kurguskina.repository.WeatherRepository;
import ru.itis.kurguskina.service.WeatherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    @Override
    public List<WeatherDto> findAll() {
        return weatherRepository.findAll().stream()
                .map(WeatherDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public WeatherDto save(Weather weather) {
        return null;
    }

    @Override
    public List<WeatherDto> getWeathersByCity(String city) {
        return weatherRepository.getWeathersByCityIgnoreCase(city).stream()
                .map(WeatherDto::fromModel)
                .collect(Collectors.toList());
    }
}
