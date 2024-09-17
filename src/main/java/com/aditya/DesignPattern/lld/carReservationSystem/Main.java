package com.aditya.DesignPattern.lld.carReservationSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehicle> vehicles = addVehicles();
        List<Store> storeList = addStore(vehicles);

        List<User> users = addUser();

        // Creating VehicleReservation System
        VehicleReservationSystem vehicleReservationSystem = new VehicleReservationSystem(storeList, users);

        User user = users.get(0);

        // User is going to search store based on location
        Location location = new Location("94599", "CA", "California");

        Store storeBasedOnLocation = vehicleReservationSystem.getStoreBasedOnLocation(location);

        // User will get vehicle List from Store for Vehicle Type : CAR
        List<Vehicle> filteredVehicleList = storeBasedOnLocation.getVehicles(VehicleType.CAR);

        Reservation reservation = storeBasedOnLocation.createReservation(filteredVehicleList.get(0), user);


        Bill bill = new Bill(reservation);

        Payment payment = new Payment();
        payment.payBill(bill);

        storeBasedOnLocation.updateReservation(reservation.getId());
    }

    private static List<User> addUser() {
        User user = new User("1", "Aditya", "12345");
        User user1 = new User("2", "Adi", "12346");
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);

        return users;
    }

    private static List<Vehicle> addVehicles() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNo("123");
        vehicle.setVehicleType(VehicleType.CAR);
        vehicle.setStatus(VehicleStatus.ACTIVE.name());

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleNo("123");
        vehicle2.setVehicleType(VehicleType.CAR);
        vehicle2.setStatus(VehicleStatus.ACTIVE.name());

        return Arrays.asList(vehicle, vehicle2);
    }

    private static List<Store> addStore(List<Vehicle> vehicles) {
        List<Store> storeList = new ArrayList<>();

        Location location = new Location("94599", "CA", "California");
        Store store = new Store("1", location);
        store.setVehicle(vehicles);

        storeList.add(store);

        return storeList;
    }
}
