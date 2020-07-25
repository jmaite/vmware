package com.weather.vmware.service;

import com.weather.vmware.model.Weather;

import java.time.LocalDate;
import java.util.List;

public interface IWeatherService {
    public List<Weather> retrieveAllWeather();
    public Weather retrieveWeather(LocalDate date);
    public Weather addWeather(Weather newWeather);
    public void deleteAllWeather();
}
