package com.weather.vmware.service;

import com.weather.vmware.data.WeatherDAO;
import com.weather.vmware.error.WeatherServiceException;
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
        try {
            if (newWeather.getId() <= 0) {
                throw new WeatherServiceException(("The Id has to be a positive integer"));
            }
            if (!weatherDAO.addWeather(newWeather)) {
                throw new WeatherServiceException(("Unable to add weather"));
            }
            return true;
        }
        catch(IllegalArgumentException ex) {
            throw new WeatherServiceException(ex.getMessage(), ex);
        }
    }

    public void deleteAllWeather() {
        weatherDAO.deleteAll();
    }
}
