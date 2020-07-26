package com.weather.vmware.service;

import com.weather.vmware.data.WeatherDAO;
import com.weather.vmware.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
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
        return weatherDAO.addWeather((newWeather));
    }

    public void deleteAllWeather() {
        weatherDAO.deleteAll();
    }
}
