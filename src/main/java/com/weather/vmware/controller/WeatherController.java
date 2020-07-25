package com.weather.vmware.controller;

import com.weather.vmware.model.Weather;
import com.weather.vmware.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    public List<Weather> retrieveAllWeather(@RequestParam(value="date", required=false) String date){
        return weatherService.retrieveAllWeather(date);
    }
}
