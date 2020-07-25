package com.weather.vmware.service;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherService implements IWeatherService{

    public List<Weather> retrieveAllWeather(){
        List<Weather> allWeather = new ArrayList<Weather>();

        LocalDate myDate = LocalDate.parse("2020-01-10");
        Location myLocation = new Location(8.0, 10.0, "Boulder", "Colorado");
        float myTemps[] = {0f, 12.1f, 111.1f, 100.9123f, 12412.8f, 1349.0f, 123.9f, 1341.2f, 109.2f, 19.2f, 12.9f, 1241.20129f,
                100.3f, 12.13f, 134.41f, 1341.12f, 1241.1f, 12.2f, 124.2f, 124.3f, 12.13f, 123.1f, 124.3f, 4423.1f};

        Weather weather1;
        weather1 = new Weather(12, myDate, myLocation, myTemps);


        LocalDate myDate2 = LocalDate.parse("2020-01-23");
        Location myLocation2 = new Location(8.0, 10.0, "Centennial", "Colorado");
        float myTemps2[] = {0f, 12.1f, 111.1f, 100.9123f, 12412.8f, 1349.0f, 123.9f, 1341.2f, 109.2f, 19.2f, 12.9f, 1241.20129f,
                100.3f, 12.13f, 134.41f, 1341.12f, 1241.1f, 12.2f, 124.2f, 124.3f, 12.13f, 123.1f, 124.3f, 4423.1f};

        Weather weather2 = new Weather(12, myDate2, myLocation2, myTemps2);


        allWeather.add(weather1);
        allWeather.add(weather2);

        return allWeather;

    }

    public Weather retrieveWeather(LocalDate date){
        LocalDate myDate = LocalDate.parse("2020-01-08");
        Location myLocation = new Location(11.0, 10.0, "Denver", "Colorado");
        float myTemps[] = {0f, 12.1f, 111.1f, 100.9123f, 12412.8f, 1349.0f, 123.9f, 1341.2f, 109.2f, 19.2f, 12.9f, 1241.20129f,
                100.3f, 12.13f, 134.41f, 1341.12f, 1241.1f, 12.2f, 124.2f, 124.3f, 12.13f, 123.1f, 124.3f, 4423.1f};


        return new Weather(333, myDate, myLocation, myTemps);
    }

    public Weather addWeather(Weather newWeather) {
        LocalDate myDate = LocalDate.parse("2020-01-14");
        Location myLocation = new Location(12.0, 10.0, "Thornton", "Colorado");
        float myTemps[] = {0f, 12.1f, 111.1f, 100.9123f, 12412.8f, 1349.0f, 123.9f, 1341.2f, 109.2f, 19.2f, 12.9f, 1241.20129f,
                100.3f, 12.13f, 134.41f, 1341.12f, 1241.1f, 12.2f, 124.2f, 124.3f, 12.13f, 123.1f, 124.3f, 4423.1f};


        return new Weather(444, myDate, myLocation, myTemps);

    }

    public void deleteAllWeather() {

    }
}
