package com.weather.vmware.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Weather implements Comparable<Weather> {
    private int id;
    private LocalDate date;
    private Location location;
    private float temperature[] = new float[24];

    public int compareTo(Weather w) {
        return this.id - w.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int inId) {
        this.id = inId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate inDate) {
        this.date = inDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location inLoc) {
        this.location = inLoc;
    }

    public float[] getTemperature() {
        return temperature;
    }

    public void setTemperature(float inTemps[]) {
        for (int i = 0; i < inTemps.length; i++) {
            this.temperature[i] = new BigDecimal(inTemps[i]).setScale(1, RoundingMode.UP).floatValue();
        }
    }
}
