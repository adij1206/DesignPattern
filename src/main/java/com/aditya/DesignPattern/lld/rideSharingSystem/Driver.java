package com.aditya.DesignPattern.lld.rideSharingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Driver {

    private String driverId;
    private String driverName;
    private String licensePlate;
    private Location location;
    private boolean isAvailable;


    public Driver(String driverName, String licensePlate, Location location) {
        this.driverId = UUID.randomUUID().toString();
        this.driverName = driverName;
        this.licensePlate = licensePlate;
        this.location = location;
        this.isAvailable = true;
    }
}
