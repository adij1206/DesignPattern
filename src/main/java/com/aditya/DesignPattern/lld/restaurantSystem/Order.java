package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Order {

    private String orderId;
    private String restaurantId;
    private String tableNumber;
    private Double totalPrice;
    private String status;

    public Order(String restaurantId, String tableNumber, String status) {
        this.orderId = UUID.randomUUID().toString();
        this.restaurantId = restaurantId;
        this.tableNumber = tableNumber;
        this.status = status;
    }
}
