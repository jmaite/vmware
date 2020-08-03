package com.weather.vmware.data;

import com.weather.vmware.model.Weather;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class WeatherDAOInMemImpl implements IWeatherDAO {
    private List<Weather> allWeatherList = new ArrayList<>();

    @Override
    public List<Weather> getAllWeather() {
        Collections.sort(allWeatherList);
        return new ArrayList(allWeatherList);
    }

    @Override
    public List<Weather> getAllWeather(LocalDate date) {
        if (date == null) {
            return getAllWeather();
        }

        List<Weather> allWeatherByDateList = new ArrayList<>();
        for(Weather currWeather : allWeatherList) {
            if (currWeather.getDate().equals(date)) {
                allWeatherByDateList.add(currWeather);
            }
        }
        Collections.sort(allWeatherByDateList);
        return new ArrayList(allWeatherByDateList);
    }

    @Override
    public boolean addWeather(Weather weather) {
        if (isIdNew(weather.getId())) {
            allWeatherList.add(weather);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAll() {
        allWeatherList.clear();
    }

    private boolean isIdNew(int inId) {
        for(Weather currWeather : allWeatherList) {
            if (currWeather.getId() == inId) {
                return false;
            }
        }
        return true;
    }
}
