package com.aditya.DesignPattern.lld.parkinglot;

import lombok.Data;

@Data
public class Ticket {

    private String ticketId;
    private ParkingSlot parkingSpot;
    private Vehicle vehicle;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    private Long startTime;
    private Long endTime;

    public ParkingSlot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSlot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }
}
