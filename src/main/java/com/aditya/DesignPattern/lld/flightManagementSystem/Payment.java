package com.aditya.DesignPattern.lld.flightManagementSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Payment {

    private String paymentId;
    private String bookingId;
    private double price;
    private PaymentStatus  status;

    public Payment(String bookingId, double price, PaymentStatus status) {
        this.paymentId = UUID.randomUUID().toString();
        this.bookingId = bookingId;
        this.price = price;
        this.status = status;
    }
}
