package com.weather.vmware.controller;

import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import com.weather.vmware.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WeatherControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService service;

    @Test
    public void givenWeather_whenGetWeather_thenReturnJsonArray() throws Exception {
        Weather weather = makeMyWeather(1, LocalDate.now());
        List<Weather> allWeather = Arrays.asList(weather);
        given(service.retrieveAllWeather()).willReturn(allWeather);

        mvc.perform(get("/weather")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(weather.getId())));
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