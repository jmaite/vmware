package com.weather.vmware.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Location {
    private double lat;
    private double lon;
    private String city;
    private String state;

    public Location(double lat, double lon, String city, String state) {
        this.lat = new BigDecimal(lat).setScale(4, RoundingMode.HALF_UP).doubleValue();
        this.lon = new BigDecimal(lon).setScale(4, RoundingMode.HALF_UP).doubleValue();
        this.city = city;
        this.state = state;
    }

    public double getLat() { return lat; }
    public double getLon() { return lon; }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
}
