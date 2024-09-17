package com.aditya.DesignPattern.lld.carReservationSystem;

public class Payment {

    public void payBill(Bill bill) {
        bill.setPaid(Boolean.TRUE);
        System.out.println("Billed Payment is done Successfully!");
    }
}
