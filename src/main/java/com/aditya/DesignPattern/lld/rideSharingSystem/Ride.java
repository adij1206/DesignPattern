package com.aditya.DesignPattern.lld.rideSharingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Ride {

    private String rideId;
    private String driverId;
    private String passengerId;
    private Location sourceLocation;
    private Location destinationLocation;
    private String status;
    private double fare;

    public Ride(
            String passengerId, Location sourceLocation, Location destinationLocation, String status, double fare
    ) {
        this.rideId = UUID.randomUUID().toString();
        this.passengerId = passengerId;
        this.sourceLocation = sourceLocation;
        this.destinationLocation = destinationLocation;
        this.status = status;
        this.fare = fare;
    }
}
