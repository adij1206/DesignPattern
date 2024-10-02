package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.util.List;
import java.util.UUID;

public class Booking {

    private String id;
    private String showId;
    private String userId;
    private List<String> seatIds;
    private double totalPrice;
    private String status;

    public Booking(double totalPrice, List<String> seatIds, String userId, String showId) {
        this.id = generateId();
        this.totalPrice = totalPrice;
        this.seatIds = seatIds;
        this.userId = userId;
        this.showId = showId;
        this.status = BookingStatus.CREATED.name();
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<String> seatIds) {
        this.seatIds = seatIds;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
