package com.weather.vmware.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import com.weather.vmware.service.IWeatherService;
import com.weather.vmware.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    public List<Weather> retrieveAllWeather(@RequestParam(value="date", required=false) String date){
        return weatherService.retrieveAllWeather(date);
    }
}
