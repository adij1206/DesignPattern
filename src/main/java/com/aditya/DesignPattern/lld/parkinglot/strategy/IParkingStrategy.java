package com.aditya.DesignPattern.lld.parkinglot.strategy;

import com.aditya.DesignPattern.lld.parkinglot.ParkingSlot;

import java.util.List;

public interface IParkingStrategy {

    ParkingSlot findParkingSlots(List<ParkingSlot> parkingSlots);
}
