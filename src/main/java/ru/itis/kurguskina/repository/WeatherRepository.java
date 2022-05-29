package ru.itis.kurguskina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kurguskina.model.Weather;

import java.util.List;


public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    List<Weather> getWeathersByCityIgnoreCase(String city);
}
