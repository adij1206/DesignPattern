package com.aditya.DesignPattern.lld.flightManagementSystem;

public class PaymentProcessor {

    public void processPayment(String bookingId, double price) {
        Payment payment = new Payment(bookingId, price, PaymentStatus.DONE);
        System.out.println(payment);
    }
}
