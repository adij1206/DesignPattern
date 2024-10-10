package com.aditya.DesignPattern.lld.rideSharingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Passenger {

    private String passengerId;
    private String name;
    private String phoneNumber;
    private Location location;

    public Passenger(String name, String phoneNumber, Location location) {
        this.passengerId = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
    }
}
