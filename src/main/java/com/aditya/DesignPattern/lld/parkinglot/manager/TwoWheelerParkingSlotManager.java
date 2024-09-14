package com.aditya.DesignPattern.lld.parkinglot.manager;

import com.aditya.DesignPattern.lld.parkinglot.strategy.NearToExitParkingStrategy;
import com.aditya.DesignPattern.lld.parkinglot.ParkingSlot;

import java.util.List;

public class TwoWheelerParkingSlotManager extends ParkingSlotManager {

    public TwoWheelerParkingSlotManager(List<ParkingSlot> parkingSlots) {
        super(parkingSlots, new NearToExitParkingStrategy());
    }
}
