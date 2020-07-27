package com.weather.vmware.service;

import com.weather.vmware.data.WeatherDAO;
import com.weather.vmware.error.WeatherServiceException;
import com.weather.vmware.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Component
public class WeatherService implements IWeatherService{

    @Autowired
    private WeatherDAO weatherDAO;

    public List<Weather> retrieveAllWeather() {
        return weatherDAO.getAllWeather();
    }

    public List<Weather> retrieveAllWeather(LocalDate date){
        return weatherDAO.getAllWeather(date);
    }

    public boolean addWeather(Weather newWeather) {
        if (Integer.valueOf(newWeather.getId()) == null) {
            throw new WeatherServiceException(("The Id is a required field"), HttpStatus.BAD_REQUEST);
        }
        if (!weatherDAO.addWeather(newWeather)) {
            throw new WeatherServiceException(("The Id already exists"), HttpStatus.BAD_REQUEST);
        }
        return true;
    }

    public void deleteAllWeather() {
        weatherDAO.deleteAll();
    }
}
