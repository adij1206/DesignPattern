package com.aditya.DesignPattern.lld.rideSharingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverService {

    private Map<String, Driver> driverMap;

    public DriverService() {
        driverMap = new HashMap<>();
    }

    public void addDriver(Driver driver) {
        driverMap.put(driver.getDriverId(), driver);
    }

    public Driver getDriver(String driverId) {
        return driverMap.get(driverId);
    }

    public List<Driver> getAllAvailableDriver(int radius) {
        List<Driver> availableDrivers = new ArrayList<>();

        double random = Math.random()*20+1;

        for (Driver driver : driverMap.values()) {
            if (driver.isAvailable() && random<=5) {
                availableDrivers.add(driver);
            }
        }

        return availableDrivers;
    }

    public void updateDriverStatus(String driverId, boolean isAvailable) {
        Driver driver = driverMap.get(driverId);
        driver.setAvailable(isAvailable);
    }
}
