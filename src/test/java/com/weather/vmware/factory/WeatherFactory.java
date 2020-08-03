package com.weather.vmware.factory;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;

import java.time.LocalDate;

public class WeatherFactory {

    public static Weather makeMyWeather(int id, LocalDate date) {
        Weather weather = new Weather();
        weather.setId(id);
        weather.setDate(date);

        Location location = new Location(244.2, 2346.2332, "Broomfield", "Colorado");
        weather.setLocation(location);

        float temps[] = new float[] {12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f};
        weather.setTemperature(temps);

        return weather;
    }
}
