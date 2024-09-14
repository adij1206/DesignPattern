package com.aditya.DesignPattern.lld.parkinglot.strategy;

import com.aditya.DesignPattern.lld.parkinglot.ParkingSlot;

import java.util.List;

public class NearToEntranceParkingStrategy implements IParkingStrategy {

    @Override
    public ParkingSlot findParkingSlots(List<ParkingSlot> parkingSlots) {
        System.out.println("Finding Near To Entrance Parking Slot");
        return parkingSlots.stream()
                .filter(ParkingSlot::getEmpty)
                .findFirst()
                .orElse(null);
    }
}
