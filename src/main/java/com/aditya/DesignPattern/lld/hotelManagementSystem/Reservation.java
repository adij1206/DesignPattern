package com.aditya.DesignPattern.lld.hotelManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Reservation {

    private String id;
    private String guestId;
    private String roomId;
    private Long checkInDate;
    private Long checkOutDate;
    private ReservationStatus status;
    private double price;

    public Reservation(String guestId, String roomId, Long checkInDate, Long checkOutDate, double price) {
        this.id = UUID.randomUUID().toString();
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
    }
}
