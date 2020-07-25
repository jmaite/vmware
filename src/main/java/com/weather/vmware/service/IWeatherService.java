package com.weather.vmware.service;

import com.weather.vmware.model.Weather;
import java.util.List;

public interface IWeatherService {
    public List<Weather> retrieveAllWeather(String date);
    public Weather addWeather(Weather newWeather);
    public void deleteAllWeather();
}
