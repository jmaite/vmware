package com.weather.vmware.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Weather {
    
    private long id;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private Location loc;
    private float temps[] = new float[24];

    @Autowired
    public Weather(long id, LocalDate date, Location loc, float temps[]) {
        this.id = id;
        this.date = date;
        this.loc = loc;
        this.temps = temps;
    }

    public long getId() {
        return id;
    }

    public void setId(long inId) {
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
        this.temps = inTemps;
    }

}
