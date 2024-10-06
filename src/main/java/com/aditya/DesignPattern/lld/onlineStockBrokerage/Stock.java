package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import lombok.Data;

import java.util.UUID;

@Data
public class Stock {

    private String id;
    private int quantity;
    private double price;

    public Stock(int quantity, double price) {
        this.id = UUID.randomUUID().toString();
        this.quantity = quantity;
        this.price = price;
    }
}
