package com.aditya.DesignPattern.lld.flightManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Booking {

    private String bookingId;
    private String flightId;
    private BookingStatus status;
    private String passengerId;
    private String seatNumber;
    private double price;

    public Booking(String flightId, String passengerId, String seatId, double price) {
        this.bookingId = UUID.randomUUID().toString();
        this.flightId = flightId;
        this.status = BookingStatus.PENDING;
        this.passengerId = passengerId;
        this.seatNumber = seatId;
        this.price = price;
    }
}
