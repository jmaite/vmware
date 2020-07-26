package com.weather.vmware.controller;

import com.weather.vmware.model.Weather;
import com.weather.vmware.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    public List<Weather> retrieveAllWeather(@RequestParam(value="date", required=false) String date){
        return weatherService.retrieveAllWeather(date);
    }

    @PostMapping(path = "/weather", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addWeatherData(@RequestBody Weather weather) throws Exception {
        if(weatherService.addWeather(weather)) {
            return new ResponseEntity<> (HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/erase")
    public void deleteAllWeather() {
        weatherService.deleteAllWeather();
    }

}
