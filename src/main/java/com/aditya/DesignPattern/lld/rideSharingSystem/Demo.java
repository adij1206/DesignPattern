package com.aditya.DesignPattern.lld.rideSharingSystem;


public class Demo {

    public static void main(String[] args) {
        Location location1 = new Location(87.1, -90.99);
        Location location2 = new Location(85.1, -98.99);
        Passenger passenger1 = new Passenger("Aditya", "9898989898", location1);
        Passenger passenger2 = new Passenger("Aditya", "9898989898", location2);

        Driver driver1 = new Driver("Driver1", "KAHM0001", location2);
        Driver driver2 = new Driver("Driver3", "KAHM0002", location1);

        RideSharingService rideSharingService = RideSharingService.getInstance();

        rideSharingService.addPassenger(passenger1);
        rideSharingService.addPassenger(passenger2);

        rideSharingService.addDriver(driver1);
        rideSharingService.addDriver(driver2);

        Location location3 = new Location(80.1, -92.99);

        Ride ride = rideSharingService.requestRide(passenger1.getPassengerId(), passenger1.getLocation(), location3);

        rideSharingService.acceptRide(driver1.getDriverId(), ride.getRideId());
        System.out.println(rideSharingService.getDriver(driver1.getDriverId()));
        rideSharingService.startRide(ride.getRideId());
        rideSharingService.completeRide(ride.getRideId());
        System.out.println(rideSharingService.getRide(ride.getRideId()));
        System.out.println(rideSharingService.getDriver(driver1.getDriverId()));

    }
}
