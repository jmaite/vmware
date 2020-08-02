package com.weather.vmware.data;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import com.weather.vmware.utils.WeatherBuilderUtils;
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
        weatherDao.addWeather(WeatherBuilderUtils.makeMyWeather(345, LocalDate.now()));
        weatherDao.addWeather(WeatherBuilderUtils.makeMyWeather(54, LocalDate.now()));
        weatherDao.addWeather(WeatherBuilderUtils.makeMyWeather(6, LocalDate.now()));
        weatherDao.addWeather(WeatherBuilderUtils.makeMyWeather(3, LocalDate.now()));

        List<Weather> allWeather = weatherDao.getAllWeather();

        assertTrue(allWeather.size() == 4);
        assertTrue(allWeather.get(0).getId() == 3);
        assertTrue(allWeather.get(3).getId() == 345);
    }

    @Test
    void testGetAllWeatherWithDate() {
        LocalDate firstDate = LocalDate.now();
        LocalDate secondDate = firstDate.minusDays(2);

        Weather weather1 = WeatherBuilderUtils.makeMyWeather(345, firstDate);
        Weather weather2 = WeatherBuilderUtils.makeMyWeather(45, firstDate);
        Weather weather3 = WeatherBuilderUtils.makeMyWeather(3, secondDate);
        Weather weather4 = WeatherBuilderUtils.makeMyWeather(35, secondDate);

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

        Weather weather1 =  WeatherBuilderUtils.makeMyWeather(345, firstDate);
        Weather weather2 =  WeatherBuilderUtils.makeMyWeather(345, secondDate);

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

        Weather weather1 = WeatherBuilderUtils.makeMyWeather(345, firstDate);
        Weather weather2 = WeatherBuilderUtils.makeMyWeather(45, firstDate);
        Weather weather3 = WeatherBuilderUtils.makeMyWeather(3, secondDate);
        Weather weather4 = WeatherBuilderUtils.makeMyWeather(35, secondDate);

        weatherDao.addWeather(weather1);
        weatherDao.addWeather(weather2);
        weatherDao.addWeather(weather3);
        weatherDao.addWeather(weather4);

        assertFalse(weatherDao.getAllWeather().isEmpty());
        weatherDao.deleteAll();
        assertTrue(weatherDao.getAllWeather().isEmpty());
    }
}