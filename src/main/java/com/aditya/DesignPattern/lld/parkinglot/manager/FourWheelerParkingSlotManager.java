package com.aditya.DesignPattern.lld.parkinglot.manager;

import com.aditya.DesignPattern.lld.parkinglot.strategy.NearToExitParkingStrategy;
import com.aditya.DesignPattern.lld.parkinglot.ParkingSlot;

import java.util.List;

public class FourWheelerParkingSlotManager extends ParkingSlotManager {

    public FourWheelerParkingSlotManager(List<ParkingSlot> parkingSlotList) {
        super(parkingSlotList, new NearToExitParkingStrategy());
    }
}
