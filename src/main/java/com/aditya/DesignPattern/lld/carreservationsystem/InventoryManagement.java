package com.aditya.DesignPattern.lld.carreservationsystem;

import java.util.List;
import java.util.stream.Collectors;

// In future, we can extend this Inventory Management for separate management of CAR, BIKE or Any type of vehicle
public class InventoryManagement {

    private List<Vehicle> vehicles;

    public InventoryManagement(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicles
                .stream()
                .filter(vehicle -> vehicleType.equals(vehicle.getVehicleType()))
                .collect(Collectors.toList());
    }
}
