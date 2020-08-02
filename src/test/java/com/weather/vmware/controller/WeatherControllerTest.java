package com.weather.vmware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.vmware.model.Location;
import com.weather.vmware.model.Weather;
import com.weather.vmware.service.WeatherService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;;
import javax.swing.text.html.HTMLDocument;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @Test
    public void givenWeather_whenGetWeatherByDate_thenReturnJsonArray() throws Exception {
        LocalDate firstDate = LocalDate.now();

        Weather weather1 = makeMyWeather(3, firstDate);
        Weather weather2 = makeMyWeather(23, firstDate);

        //testing the date query string returns expected values
        List<Weather> firstDateWeather = new ArrayList<>();
        firstDateWeather.add(weather1);
        firstDateWeather.add(weather2);

        given(service.retrieveAllWeather(firstDate)).willReturn(firstDateWeather);
        mvc.perform(get("/weather?date={date}", firstDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(weather1.getId())));

    }

    @Test
    public void addWeather_thenReturnEmptyJsonArray() throws Exception {
        JSONObject location = new JSONObject();
        location.put("lat", 12.1324);
        location.put("lon", 12.324);
        location.put("city", "Broomfield");
        location.put("state", "Colorado");

        JSONArray temps = new JSONArray();
        temps.put(3f);
        temps.put(23f);
        temps.put(4.1f);
        temps.put(33.0f);
        temps.put(56.2f);

        JSONObject obj = new JSONObject();
        obj.put("id", 2);
        obj.put("date", 2009-10-1);
        obj.put("location", location);
        obj.put("temperature", temps);

        mvc.perform(post("/weather")
                .content(obj.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void whenDeleteWeather_thenReturnEmptyJsonArray() throws Exception {
        mvc.perform(delete("/erase")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
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