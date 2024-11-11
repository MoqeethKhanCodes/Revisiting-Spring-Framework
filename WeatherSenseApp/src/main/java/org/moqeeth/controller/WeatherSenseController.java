package org.moqeeth.controller;

import lombok.extern.slf4j.Slf4j;
import org.moqeeth.model.WeatherSenseResponse;
import org.moqeeth.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class WeatherSenseController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("getWeatherData")
    public void getWeatherData() {
        WeatherSenseResponse weatherSenseResponse = weatherService.getAndProcessData("Hyderabad", "Telangana", "India");

        log.info("Current Weather = " + weatherSenseResponse);
    }


}
