package com.weather.vmware.data;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class WeatherDAOInMemImplTest {

    WeatherDAOInMemImpl weatherDao;

    @BeforeEach
    void setUp() {
        weatherDao = new WeatherDAOInMemImpl();
    }

    @Test
    void getAllWeatherSortedById() {
        weatherDao.addWeather(makeMyWeather(345, LocalDate.now()));
        weatherDao.addWeather(makeMyWeather(54, LocalDate.now()));
        weatherDao.addWeather(makeMyWeather(6, LocalDate.now()));
        weatherDao.addWeather(makeMyWeather(3, LocalDate.now()));

        List<Weather> allWeather = weatherDao.getAllWeather();

        assertTrue(allWeather.size() == 4);
        assertTrue(allWeather.get(0).getId() == 3);
        assertTrue(allWeather.get(3).getId() == 345);
    }

    @Test
    void testGetAllWeatherWithDate() {
        LocalDate firstDate = LocalDate.now();
        LocalDate secondDate = firstDate.minusDays(2);

        Weather weather1 = makeMyWeather(345, firstDate);
        Weather weather2 = makeMyWeather(45, firstDate);
        Weather weather3 = makeMyWeather(3, secondDate);
        Weather weather4 = makeMyWeather(35, secondDate);

        weatherDao.addWeather(weather1);
        weatherDao.addWeather(weather2);
        weatherDao.addWeather(weather3);
        weatherDao.addWeather(weather4);

        List<Weather> allWeatherFirstDate = weatherDao.getAllWeather(firstDate);
        assertTrue(allWeatherFirstDate.contains(weather1) && allWeatherFirstDate.contains(weather2));

        List<Weather> allWeatherSecondDate = weatherDao.getAllWeather(secondDate);
        assertTrue(allWeatherSecondDate.contains(weather3) && allWeatherSecondDate.contains(weather4));
    }

    @Test
    void addWeather() {
        LocalDate firstDate = LocalDate.now();
        LocalDate secondDate = firstDate.minusDays(2);

        Weather weather1 = makeMyWeather(345, firstDate);
        Weather weather2 = makeMyWeather(345, secondDate);

        assertTrue(weatherDao.addWeather(weather1));
        assertFalse(weatherDao.addWeather(weather2));
    }

    @Test
    void deleteAllWhenEmpty() {
        List<Weather> allWeather = weatherDao.getAllWeather();
        weatherDao.deleteAll();
        assertTrue(allWeather.isEmpty());
    }

    @Test
    void deleteAllWithData() {
        LocalDate firstDate = LocalDate.now();
        LocalDate secondDate = firstDate.minusDays(2);

        Weather weather1 = makeMyWeather(345, firstDate);
        Weather weather2 = makeMyWeather(45, firstDate);
        Weather weather3 = makeMyWeather(3, secondDate);
        Weather weather4 = makeMyWeather(35, secondDate);

        weatherDao.addWeather(weather1);
        weatherDao.addWeather(weather2);
        weatherDao.addWeather(weather3);
        weatherDao.addWeather(weather4);

        assertFalse(weatherDao.getAllWeather().isEmpty());
        weatherDao.deleteAll();
        assertTrue(weatherDao.getAllWeather().isEmpty());
    }

    private Weather makeMyWeather(int id, LocalDate date) {
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