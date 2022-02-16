package ru.itis.kurguskina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kurguskina.controller.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
