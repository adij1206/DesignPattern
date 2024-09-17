package com.aditya.DesignPattern.lld.carReservationSystem;

import java.math.BigDecimal;

public class Bill {

    private Reservation reservation;
    private BigDecimal totalAmount;
    private Boolean paid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalAmount = new BigDecimal((reservation.getToTimeStamp()-reservation.getFromTimeStamp()*100));
        this.paid = Boolean.FALSE;
    }


    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }
}
