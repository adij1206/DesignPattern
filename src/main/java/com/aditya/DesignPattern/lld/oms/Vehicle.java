package com.aditya.DesignPattern.lld.oms;

public class Vehicle {

    private String vin;
    private String model;
    private double price;
    private boolean isSold;

    public Vehicle(String vin, String model, double price) {
        this.vin = vin;
        this.model = model;
        this.price = price;
        this.isSold = false;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
