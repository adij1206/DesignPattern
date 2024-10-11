package com.aditya.DesignPattern.lld.hotelManagementSystem;

import lombok.Data;

@Data
public class Room {

    private String roomId;
    private RoomStatus roomStatus;
    private double price;
    private RoomType roomType;


    public Room(String roomId, double price, RoomType roomType) {
        this.roomId = roomId;
        this.roomStatus = RoomStatus.AVAILABLE;
        this.price = price;
        this.roomType = roomType;
    }
}
