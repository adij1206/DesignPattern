package com.aditya.DesignPattern.lld.flightManagementSystem;

import lombok.Data;

@Data
public class Seat {

    private String id;
    private String seatNumber;
    private String aircraftId;
    private SeatStatus status;
    private SeatType seatType;

    public Seat(String seatNumber, String aircraftId, SeatType seatType) {
        this.id = aircraftId + "_" + seatNumber;
        this.seatNumber = seatNumber;
        this.aircraftId = aircraftId;
        this.status = SeatStatus.AVAILABLE;
        this.seatType = seatType;
    }
}
