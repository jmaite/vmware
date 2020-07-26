package com.weather.vmware.service;

import com.weather.vmware.data.WeatherDAO;
import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherService implements IWeatherService{

    @Autowired
    private WeatherDAO weatherDAO;

    public List<Weather> retrieveAllWeather(String date){
        if (date != null) {
            return weatherDAO.getAllWeather(formatDate(date));
        }
        return weatherDAO.getAllWeather();
    }

    public boolean addWeather(Weather newWeather) {
        return weatherDAO.addWeather((newWeather));
    }

    public void deleteAllWeather() {
        weatherDAO.deleteAll();
    }

    private LocalDate formatDate(String dateStr) {
        LocalDate date = null;

        try {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(Weather.DATE_FORMAT));

        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
