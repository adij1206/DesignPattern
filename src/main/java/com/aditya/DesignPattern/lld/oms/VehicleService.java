package com.aditya.DesignPattern.lld.oms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleService {

    private Map<String, Vehicle> vehicles;

    public VehicleService() {
        this.vehicles = new HashMap<>();
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.put(vehicle.getVin(), vehicle);
    }

    public Vehicle getVehicleByVin(String vin) {
        return this.vehicles.get(vin);
    }

    public void markVehicleAsSold(String vin) {
        Vehicle vehicle = vehicles.get(vin);
        vehicle.setSold(true);
    }

    public List<Vehicle> getAllAvailableVehicle() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles.values()) {
            if (!vehicle.isSold()) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }

    public boolean validateIfVehicleIsPresent(List<String> vins) {
        for (Vehicle vehicle : vehicles.values()) {
            if (vins.contains(vehicle.getVin()) && vehicle.isSold()) {
                return false;
            }
        }

        return true;
    }

    public double getTotalAmount(List<String> vins) {
        double totalAmount = 0.0;
        for (Vehicle vehicle : vehicles.values()) {
            if (vins.contains(vehicle.getVin())) {
                totalAmount += vehicle.getPrice();
            }
        }

        return totalAmount;
    }

}
