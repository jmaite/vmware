package com.weather.vmware.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Weather implements Comparable<Weather> {
    private int id;
    private LocalDate date;
    private Location loc;
    private float temps[] = new float[24];

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

    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location inLoc) {
        this.loc = inLoc;
    }

    public float[] getTemps() {
        return temps;
    }

    public void setTemps(float inTemps[]) {
        for (int i = 0; i < inTemps.length; i++) {
            this.temps[i] = new BigDecimal(inTemps[i]).setScale(1, RoundingMode.UP).floatValue();
        }
    }
}
