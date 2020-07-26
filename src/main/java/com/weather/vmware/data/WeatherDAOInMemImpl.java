package com.weather.vmware.data;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherDAOInMemImpl implements WeatherDAO {
    private List<Weather> allWeatherList = new ArrayList<>();

    public WeatherDAOInMemImpl() {

        //THIS DATA IS HARDCODED AND NEEDS TO BE REMOVED
        LocalDate myDate = LocalDate.parse("2020-01-10");
        Location myLocation = new Location(8.0, 10.0, "Boulder", "Colorado");
        float myTemps[] = {0f, 12.1f, 111.1f, 100.9123f, 12412.8f, 1349.0f, 123.9f, 1341.2f, 109.2f, 19.2f, 12.9f, 1241.20129f,
                100.3f, 12.13f, 134.41f, 1341.12f, 1241.1f, 12.2f, 124.2f, 124.3f, 12.13f, 123.1f, 124.3f, 4423.1f};

        Weather weather1 = new Weather(114324, myDate, myLocation, myTemps);

        LocalDate myDate2 = LocalDate.parse("2020-01-23");
        Location myLocation2 = new Location(8.0, 10.0, "Centennial", "Colorado");
        float myTemps2[] = {0f, 12.1f, 111.1f, 100.9123f, 12412.8f, 1349.0f, 123.9f, 1341.2f, 109.2f, 19.2f, 12.9f, 1241.20129f,
                100.3f, 12.13f, 134.41f, 1341.12f, 1241.1f, 12.2f, 124.2f, 124.3f, 12.13f, 123.1f, 124.3f, 4423.1f};

        Weather weather2 = new Weather(987, myDate2, myLocation2, myTemps2);

        allWeatherList.add(weather1);
        allWeatherList.add(weather2);
    }

    @Override
    public List<Weather> getAllWeather() {
        return allWeatherList;
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
        return allWeatherByDateList;
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
