package com.weather.vmware.controller;

import com.weather.vmware.error.ErrorResponse;
import com.weather.vmware.model.Weather;
import com.weather.vmware.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/weather")
    @ResponseStatus(HttpStatus.OK)
    public List<Weather> retrieveAllWeather(
            @RequestParam(value="date", required=false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){

        if (date != null) {
           return weatherService.retrieveAllWeather(date);
        }
        return weatherService.retrieveAllWeather();
    }

    @PostMapping(path = "/weather", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addWeatherData(@RequestBody Weather weather) throws Exception {
        if(weatherService.addWeather(weather)) {
            return new ResponseEntity<> (HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/erase")
    public ResponseEntity<Object> deleteAllWeather() {
        weatherService.deleteAllWeather();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public final ResponseEntity<Object> handleBadDateFormatException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String details = "The " + ex.getName() + " had an invalid value of: " + ex.getValue();
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
