package com.weather.vmware.controller;

import com.weather.vmware.error.ErrorResponse;
import com.weather.vmware.error.WeatherServiceException;
import com.weather.vmware.model.Weather;
import com.weather.vmware.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> retrieveAllWeather (
            @RequestParam(value="date", required=false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        if (date != null) {
           return weatherService.retrieveAllWeather(date);
        }
        return weatherService.retrieveAllWeather();
    }

    @PostMapping(path = "/weather", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addWeatherData(@RequestBody Weather weather) throws Exception {
       weatherService.addWeather(weather);
    }

    @DeleteMapping("/erase")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllWeather() throws Exception {
        weatherService.deleteAllWeather();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<Object> handleBadDateFormatException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String details = "The " + ex.getName() + " had an invalid value of: " + ex.getValue();
        ErrorResponse error = new ErrorResponse(new Date(),"Validation Failed", details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(WeatherServiceException.class)
    public final ResponseEntity<Object> handleWeatherServiceException(WeatherServiceException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(new Date(), ex.getMessage(), "");
        return new ResponseEntity<>(error, ex.getHttpStatusCode());
    }
}
