package com.aditya.DesignPattern.lld.flightManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SeatService {

    private Map<String, Seat> seatMap;

    public SeatService() {
        seatMap = new HashMap<>();
    }

    public void addSeat(Seat seat) {
        seatMap.put(seat.getId(), seat);
    }

    public Seat getSeat(String seatNumber, String aircraftNumber) {
        String key = aircraftNumber + "_" + seatNumber;
        return seatMap.get(key);
    }

    public List<Seat> getAllAvailableSeats(String aircraftNumber) {
        List<Seat> availableSeats = new ArrayList<>();

        for (Seat seat : seatMap.values()) {
            if (seat.getAircraftId().equals(aircraftNumber) && seat.getStatus().equals(SeatStatus.AVAILABLE)) {
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }

    public synchronized void updateSeatStatus(String seatId, SeatStatus newStatus) {
        Seat seat = seatMap.get(seatId);
        seat.setStatus(newStatus);
    }

    public synchronized void updateSeatStatus(String seatNumber, String airCraftId, SeatStatus newStatus) {
        Seat seat = seatMap.get(airCraftId + "_" + seatNumber);
        seat.setStatus(newStatus);
    }

    public void updateAllSeatStatusOfAirCraft(String aircraftNumber) {
        for (Seat seat : seatMap.values()) {
            if (seat.getAircraftId().equals(aircraftNumber)) {
                seat.setStatus(SeatStatus.AVAILABLE);
            }
        }
    }
}
