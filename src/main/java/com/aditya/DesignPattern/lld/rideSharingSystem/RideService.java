package com.aditya.DesignPattern.lld.rideSharingSystem;

import java.util.HashMap;
import java.util.Map;

public class RideService {

    private Map<String, Ride> rides;

    public RideService() {
        rides = new HashMap<>();
    }

    public void addRide(Ride ride) {
        rides.put(ride.getRideId(), ride);
    }

    public Ride getRide(String rideId) {
        return rides.get(rideId);
    }

    public synchronized void updateRideStatus(String rideId, String status) {
        Ride ride = rides.get(rideId);
        ride.setStatus(status);
    }

    public synchronized void assignRideAndAccept(String rideId, String rideStatus, String driverId){
        Ride ride = rides.get(rideId);
        ride.setStatus(rideStatus);
        ride.setDriverId(driverId);
    }

    public synchronized void updateStatusAndFare(String rideId, String rideStatus, double fare){
        Ride ride = rides.get(rideId);
        ride.setStatus(rideStatus);
        ride.setFare(fare);
    }
}
