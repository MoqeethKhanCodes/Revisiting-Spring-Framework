package org.moqeeth.controller;

import lombok.extern.slf4j.Slf4j;
import org.moqeeth.model.WeatherSenseResponse;
import org.moqeeth.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class WeatherSenseController {

    @Autowired
    WeatherService weatherService;

    @GetMapping("getWeatherData")
    public String getWeatherData(
            @RequestParam("city") String city,
            @RequestParam(name = "state", required = false) String state,
            @RequestParam(name = "country", required = false) String country,
            Model model) {

        WeatherSenseResponse weatherSenseResponse = weatherService.getAndProcessData(city, state, country);

        log.info("Current Weather = " + weatherSenseResponse);

        if (weatherSenseResponse != null) {
            model.addAttribute("city", weatherSenseResponse.getName());
            model.addAttribute("country", weatherSenseResponse.getSys().getCountry());
            model.addAttribute("weatherDescription", weatherSenseResponse.getWeather().get(0).getDescription());
            model.addAttribute("temperature", weatherSenseResponse.getMain().getTemp());
            model.addAttribute("humidity", weatherSenseResponse.getWind().getSpeed());
            model.addAttribute("windSpeed", weatherSenseResponse.getMain().getHumidity());

            String weatherIcon = "wi wi-com-" + weatherSenseResponse.getWeather().get(0).getId();
            model.addAttribute("weatheIcon", weatherIcon);
        }else {
            model.addAttribute("error", "City not found");
        }

        return "weather";
    }


}
