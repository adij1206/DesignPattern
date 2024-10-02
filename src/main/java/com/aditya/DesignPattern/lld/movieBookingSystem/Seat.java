package com.aditya.DesignPattern.lld.movieBookingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Seat {

    private String id;
    private int row;
    private int column;
    private double price;
    private String type;
    private String status;
}
