package com.aditya.DesignPattern.lld.flightManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class AirCraft {

    private String aircraftId;
    private int totalSeat;
    private boolean isAvailable;

    public AirCraft(int totalSeat) {
        this.aircraftId = UUID.randomUUID().toString();
        this.totalSeat = totalSeat;
        this.isAvailable = true;
    }
}
