package ru.itis.kurguskina.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.kurguskina.dto.AppealDto;
import ru.itis.kurguskina.model.Appeal;
import ru.itis.kurguskina.repository.AppealRepository;
import ru.itis.kurguskina.service.AppealService;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppealServiceImpl implements AppealService {

    private final AppealRepository appealRepository;

    @Autowired
    public AppealServiceImpl(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }

    @Override
    public AppealDto save(Appeal appeal) {
        return AppealDto.fromModel(appealRepository.save(appeal));
    }

    @Override
    public List<AppealDto> getAppealsByUserId(Integer id) {
        return appealRepository.getAppealsByUserId(id).stream()
                .map(AppealDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppealDto> getAppealsByWeatherCity(String city) {
        return appealRepository.getAppealsByWeatherCityIgnoreCase(city).stream()
                .map(AppealDto::fromModel)
                .collect(Collectors.toList());
    }
}
