package ru.itis.kurguskina.service;

import ru.itis.kurguskina.dto.AppealDto;
import ru.itis.kurguskina.model.Appeal;

import java.util.List;

public interface AppealService {

    AppealDto save(Appeal appeal);

    List<AppealDto> getAppealsByUserId(Integer id);

    List<AppealDto> getAppealsByWeatherCity(String city);
}
