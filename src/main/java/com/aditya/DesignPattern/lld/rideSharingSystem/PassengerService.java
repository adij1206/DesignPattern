package com.aditya.DesignPattern.lld.rideSharingSystem;

import java.util.HashMap;
import java.util.Map;

public class PassengerService {

    private Map<String, Passenger> passengers;

    public PassengerService() {
        passengers = new HashMap<>();
    }

    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getPassengerId(), passenger);
    }

    public Passenger getPassenger(String passengerId) {
        return passengers.get(passengerId);
    }

    public void updateLocation(String passengerId, Location location) {
        Passenger passenger = passengers.get(passengerId);
        passenger.setLocation(location);
    }
}
