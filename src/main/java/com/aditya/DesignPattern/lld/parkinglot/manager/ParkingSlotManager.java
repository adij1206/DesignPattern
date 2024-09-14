package com.aditya.DesignPattern.lld.parkinglot.manager;

import com.aditya.DesignPattern.lld.parkinglot.strategy.IParkingStrategy;
import com.aditya.DesignPattern.lld.parkinglot.ParkingSlot;
import com.aditya.DesignPattern.lld.parkinglot.Vehicle;

import java.util.List;


public abstract class ParkingSlotManager {

    private List<ParkingSlot> parkingSlotList;
    private IParkingStrategy iParkingStrategy;

    public ParkingSlotManager(List<ParkingSlot> parkingSlotList, IParkingStrategy iParkingStrategy) {
        this.parkingSlotList = parkingSlotList;
        this.iParkingStrategy = iParkingStrategy;
    }

    public ParkingSlot findParkingSlot() {
        return iParkingStrategy.findParkingSlots(parkingSlotList);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSlot parkingSlot) {
        System.out.println("Parking Vehicle");
        parkingSlot.setVehicle(vehicle);
        parkingSlot.setEmpty(false);
    }

    public void unParkVehicle(Vehicle vehicle, ParkingSlot parkingSlot) {
        parkingSlot.setVehicle(null);
        parkingSlot.setEmpty(true);
        System.out.println("UnParked Vehicle");
    }
}
