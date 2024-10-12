package com.aditya.DesignPattern.lld.flightManagementSystem;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Flight {

    private String flightId;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String aircraftId;

    public Flight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, String aircraftId) {
        this.flightId = UUID.randomUUID().toString();
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraftId = aircraftId;
    }
}
