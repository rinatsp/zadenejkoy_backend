package com.vk.hack.atmmap.model;

public class ATM {
    private long id;
    private String address;
    private String city;
    private double lon;
    private double lat;
    private String bank;
    private String name;
    private Type type;

    public ATM() {
    }

    public enum Type{
        ATM,
        TERMINAL,
        CASHBOX
    }

    public ATM(long id, String address, String city, double lon, double lat, String bank, String name, Type type) {
        this.id = id;
        this.address = address;
        this.city = city;
        this.lon = lon;
        this.lat = lat;
        this.bank = bank;
        this.name = name;
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
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

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
