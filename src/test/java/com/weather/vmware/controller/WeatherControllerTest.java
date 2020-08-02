package com.weather.vmware.controller;

import com.weather.vmware.model.Weather;
import com.weather.vmware.service.WeatherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WeatherService service;

  /**  @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

        Weather weather = new Weather();
        List<Weather> allWeather = Arrays.asList(weather);
        given(service.retrieveAllWeather()).willReturn(allWeather);

        mvc.perform(get("/weather")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    } */
}