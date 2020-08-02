package com.weather.vmware.service;

import com.weather.vmware.data.WeatherDAO;
import com.weather.vmware.error.WeatherServiceException;
import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
public class WeatherServiceTest {

    @TestConfiguration
    static class WeatherServiceTestContextConfiguration {

        @Bean
        public WeatherService weatherService() {
            return new WeatherService();
        }
    }

    @Autowired
    private WeatherService weatherService;

    @MockBean
    private WeatherDAO weatherDAO;

    @Test
    public void addWeatherWithoutIdGetException() {
        Weather weather = new Weather();
        Location location = new Location(244.2, 2346.2332, "Broomfield", "Colorado");
        float temps[] = new float[] {12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f};
        LocalDate date = LocalDate.now();
        weather.setDate(date);
        weather.setLocation(location);
        weather.setTemperature(temps);

        Exception exception = assertThrows(WeatherServiceException.class, () -> { this.weatherService.addWeather(weather); });

        assertTrue(exception.getMessage().contains("The Id has to be a positive integer"));
    }

    @Test
    public void addWeatherDaoFailureGetException() {
        Weather weather = new Weather();
        Location location = new Location(244.2, 2346.2332, "Broomfield", "Colorado");
        float temps[] = new float[] {12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.45f, 23.34f};
        LocalDate date = LocalDate.now();
        weather.setId(1);
        weather.setDate(date);
        weather.setLocation(location);
        weather.setTemperature(temps);

        given(this.weatherDAO.addWeather(weather)).willReturn(false);
        Exception exception = assertThrows(WeatherServiceException.class, () -> { this.weatherService.addWeather(weather); });

        assertTrue(exception.getMessage().contains("Unable to add weather"));
    }
}
