package com.weather.vmware.data;

import com.weather.vmware.model.Weather;

import java.time.LocalDate;
import java.util.List;

public interface WeatherDAO {
    List<Weather> getAllWeather();

    List<Weather> getAllWeather(LocalDate date);

    boolean addWeather(Weather weather);

    void deleteAll();
}
