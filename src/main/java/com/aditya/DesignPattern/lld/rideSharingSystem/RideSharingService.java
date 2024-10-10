package com.aditya.DesignPattern.lld.rideSharingSystem;

import java.util.List;

public class RideSharingService {

    private static RideSharingService rideSharingService;

    private PassengerService passengerService;
    private RideService rideService;
    private DriverService driverService;
    //private Queue<Ride> rides;

    private RideSharingService() {
        passengerService = new PassengerService();
        rideService = new RideService();
        driverService = new DriverService();
    }

    public synchronized static RideSharingService getInstance() {
        if (rideSharingService == null) {
            rideSharingService = new RideSharingService();
        }

        return rideSharingService;
    }

    public void addPassenger(Passenger passenger) {
        passengerService.addPassenger(passenger);
    }

    public Passenger getPassenger(String passengerId) {
        return passengerService.getPassenger(passengerId);
    }

    public void updateLocation(String passengerId, Location location) {
        passengerService.updateLocation(passengerId, location);
    }

    public Ride requestRide(String passengerId, Location sourceLocation, Location destinationLocation) {
        Ride ride = new Ride(passengerId, sourceLocation, destinationLocation, RideStatus.REQUESTED.name(), 0.0);
        rideService.addRide(ride);
        notifyDrivers();
        return ride;
    }

    private void notifyDrivers() {
        List<Driver> drivers = driverService.getAllAvailableDriver(5);
        for (Driver driver : drivers) {
            System.out.println("notifying driver " + driver.getDriverId());
        }
    }


    public void acceptRide(String driverId, String rideId) {
        Ride ride = rideService.getRide(rideId);
        rideService.assignRideAndAccept(rideId, RideStatus.ACCEPTED.name(), driverId);
        driverService.updateDriverStatus(driverId, false);
        notifyPassenger(ride.getPassengerId(), RideStatus.ACCEPTED);
    }

    private void notifyPassenger(String passengerId, RideStatus rideStatus) {
        switch (rideStatus) {
            case ACCEPTED, IN_PROGRESS, CANCELLED, COMPLETED:
                System.out.println("notifying passenger, ride status : " + rideStatus.name() + " " + passengerId);
        }
    }

    private void notifyDriver(String driverId, RideStatus rideStatus) {
        switch (rideStatus) {
            case CANCELLED, COMPLETED:
                System.out.println("notifying driver, ride status : " + rideStatus.name() + " " + driverId);
        }
    }

    public void startRide(String rideId) {
        Ride ride = rideService.getRide(rideId);
        rideService.updateRideStatus(rideId, RideStatus.IN_PROGRESS.name());
        notifyPassenger(ride.getPassengerId(), RideStatus.IN_PROGRESS);
        System.out.println("Ride started");
    }

    public void completeRide(String rideId) {
        Ride ride = rideService.getRide(rideId);

        double fare = calculateFare(ride);
        processPayment();

        rideService.updateStatusAndFare(rideId, RideStatus.COMPLETED.name(), fare);
        driverService.updateDriverStatus(ride.getDriverId(), true);
        System.out.println("Ride completed with fare" + fare);
        notifyPassenger(ride.getPassengerId(), RideStatus.COMPLETED);
        notifyDriver(ride.getDriverId(), RideStatus.COMPLETED);
    }

    public void cancelRide(String rideId) {
        Ride ride = rideService.getRide(rideId);

        rideService.updateRideStatus(rideId, RideStatus.CANCELLED.name());
        driverService.updateDriverStatus(ride.getDriverId(), true);

        notifyPassenger(ride.getPassengerId(), RideStatus.CANCELLED);
        notifyDriver(ride.getDriverId(), RideStatus.CANCELLED);
    }

    private void processPayment() {
        System.out.println("received Payment");
    }

    private double calculateFare(Ride ride) {
        double baseFare = 2.0;
        double farePerKm = 5.0;
        double farePerMinute = 1.0;

        double calculateDistance = calculateDistance(ride.getSourceLocation(), ride.getDestinationLocation());
        double calculateDuration = calculateDuration(ride.getSourceLocation(), ride.getDestinationLocation());

        return baseFare + farePerKm * calculateDistance + farePerMinute * calculateDuration;
    }

    private double calculateDistance(Location sourceLocation, Location destinationLocation) {
        return Math.random() * 20 + 1;
    }

    private double calculateDuration(Location source, Location destination) {
        // Calculate the estimated duration between two locations based on distance and average speed
        // For simplicity, let's assume an average speed of 30 km/h
        double distance = calculateDistance(source, destination);
        return (distance / 30) * 60; // Convert hours to minutes
    }

    public void addDriver(Driver driver) {
        driverService.addDriver(driver);
    }

    public Driver getDriver(String driverId) {
        return driverService.getDriver(driverId);
    }

    public Ride getRide(String rideId) {
        return rideService.getRide(rideId);
    }
}
