package com.aditya.DesignPattern.lld.parkinglot.factory;

import com.aditya.DesignPattern.lld.parkinglot.VehicleType;
import com.aditya.DesignPattern.lld.parkinglot.manager.FourWheelerParkingSlotManager;
import com.aditya.DesignPattern.lld.parkinglot.manager.ParkingSlotManager;
import com.aditya.DesignPattern.lld.parkinglot.manager.TwoWheelerParkingSlotManager;

public class ParkingManagerFactory {

    private TwoWheelerParkingSlotManager twoWheelerParkingSlotManager = null;
    private FourWheelerParkingSlotManager fourWheelerParkingSlotManager = null;

    public ParkingManagerFactory(
            TwoWheelerParkingSlotManager twoWheelerParkingSlotManager,
            FourWheelerParkingSlotManager fourWheelerParkingSlotManager
    ) {
        this.twoWheelerParkingSlotManager = twoWheelerParkingSlotManager;
        this.fourWheelerParkingSlotManager = fourWheelerParkingSlotManager;
    }

    public ParkingSlotManager getParkingSlotManager(VehicleType vehicleType) {
        return switch (vehicleType) {
            case TWO_WHEELER -> twoWheelerParkingSlotManager;
            case FOUR_WHEELER -> fourWheelerParkingSlotManager;
        };
    }
}
