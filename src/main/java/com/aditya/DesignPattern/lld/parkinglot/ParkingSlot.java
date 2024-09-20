package com.aditya.DesignPattern.lld.parkinglot;

import java.math.BigDecimal;


public abstract class ParkingSlot {

    private String id;
    private Vehicle vehicle;
    private Boolean isEmpty;
    private BigDecimal price;
    private String type;

    public ParkingSlot(String id, Boolean isEmpty, BigDecimal price, String type) {
        this.id = id;
        this.isEmpty = isEmpty;
        this.price = price;
        this.type = type;
    }

    public BigDecimal getPrice() {
        return new BigDecimal(0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
