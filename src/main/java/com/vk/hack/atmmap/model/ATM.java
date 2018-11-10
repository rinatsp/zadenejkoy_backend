package com.vk.hack.atmmap.model;

public class ATM {
    private String city;
    private double lon;
    private double lat;
    private String name;

    public ATM() {
    }

    public ATM(String city, double lon, double lat, String name) {
        this.city = city;
        this.lon = lon;
        this.lat = lat;
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
