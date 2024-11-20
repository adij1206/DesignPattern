package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Payment {

    private String id;
    private String orderId;
    private Double amount;
    private String status;
    private String modeOfPayment;

    public Payment(String orderId, Double amount, String status) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
    }
}
