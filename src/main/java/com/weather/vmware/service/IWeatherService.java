package com.weather.vmware.service;

import com.weather.vmware.model.Weather;

import java.time.LocalDate;
import java.util.List;

public interface IWeatherService {
    List<Weather> retrieveAllWeather();
    List<Weather> retrieveAllWeather(LocalDate date);
    boolean addWeather(Weather newWeather);
    void deleteAllWeather();
}
