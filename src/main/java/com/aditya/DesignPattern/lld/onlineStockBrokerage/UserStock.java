package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import lombok.Data;

@Data
public class UserStock {

    private String stockId;
    private int quantity;
    private double price;

    public UserStock(String stockId, int quantity, double price) {
        this.stockId = stockId;
        this.quantity = quantity;
        this.price = price;
    }
}
