package ru.itis.kurguskina.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.kurguskina.dto.AppealDto;
import ru.itis.kurguskina.service.AppealService;

import java.util.List;

@RestController
public class AppealController {

    private final AppealService appealService;

    @Autowired
    public AppealController(AppealService appealService) {
        this.appealService = appealService;
    }

    @Operation(summary = "Returns appeals by user id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Appeals were get",
            content = {@Content(mediaType = "application/json")})})
    @GetMapping("/appeals/{user_id}")
    public List<AppealDto> getAppealsByUserId(@PathVariable Integer user_id) {
        return appealService.getAppealsByUserId(user_id);
    }

    @Operation(summary = "Returns appeals by city")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Appeals were get",
            content = {@Content(mediaType = "application/json")})})
    @GetMapping("/appeals/city/{city}")
    public List<AppealDto> getAppealsByCity(@PathVariable String city) {
        return appealService.getAppealsByWeatherCity(city);
    }
}
