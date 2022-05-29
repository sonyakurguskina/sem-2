package ru.itis.kurguskina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.kurguskina.model.Appeal;


import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Integer> {
    List<Appeal> getAppealsByUserId(Integer id);

    List<Appeal> getAppealsByWeatherCityIgnoreCase(String city);
}