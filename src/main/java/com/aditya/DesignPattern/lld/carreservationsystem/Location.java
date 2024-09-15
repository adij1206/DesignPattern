package com.aditya.DesignPattern.lld.carreservationsystem;

public class Location {

    private String zipCode;
    private String city;
    private String state;

    public Location(String zipCode, String city, String state) {
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
