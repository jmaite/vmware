package com.weather.vmware.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherTest {

    @Test
    void setTemperature() {
        Weather weather = new Weather();

        float temps[] = new float[] {12.323f, 14.523f, 134.324f, 2342.1352f, 12.46f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.4501f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.4501f, 23.34f,
                12.323f, 14.523f, 134.324f, 2342.1352f, 12.4501f, 23.34f};

        weather.setTemperature(temps);
        float expectedTemps[] = new float[] {12.3f, 14.5f, 134.3f, 2342.1f, 12.5f, 23.3f,
                12.3f, 14.5f, 134.3f, 2342.1f, 12.5f, 23.3f,
                12.3f, 14.5f, 134.3f, 2342.1f, 12.5f, 23.3f,
                12.3f, 14.5f, 134.3f, 2342.1f, 12.5f, 23.3f};

        assertArrayEquals(expectedTemps, weather.getTemperature());
    }

    @Test
    void setTemperatureWithException() {
        Weather weather = new Weather();

        float temps[] = new float[25];

        Exception exception = assertThrows(IllegalArgumentException.class, () -> { weather.setTemperature(temps); });
    }
}