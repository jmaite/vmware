package com.weather.vmware.controller;

import java.time.LocalDate;
import java.util.List;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import com.weather.vmware.service.IWeatherService;
import com.weather.vmware.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    public List<Weather> retrieveAllWeather(){
        return weatherService.retrieveAllWeather();
    }

    @GetMapping("/weather?date{date}")
    public Weather weather(@PathVariable String date) {
        return weatherService.retrieveWeather(LocalDate.parse(date));
    }
}
