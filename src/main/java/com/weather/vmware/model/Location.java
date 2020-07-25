package com.weather.vmware.model;

public class Location {
    private final double lat;
    private final double lon;
    private final String city;
    private final String state;

    public Location(double lat, double lon, String city, String state) {
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
