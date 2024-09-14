package com.aditya.DesignPattern.lld.parkinglot.strategy;

import com.aditya.DesignPattern.lld.parkinglot.ParkingSlot;

import java.util.List;

public class NearToExitParkingStrategy implements IParkingStrategy {

    @Override
    public ParkingSlot findParkingSlots(List<ParkingSlot> parkingSlots) {
        System.out.println("Finding Near To Exit Parking Slot");
        return parkingSlots.stream()
                .filter(ParkingSlot::getEmpty)
                .findFirst()
                .orElse(null);
    }
}
