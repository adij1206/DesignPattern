package com.aditya.DesignPattern.lld.hotelManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ReservationService {

    private Map<String, Reservation> reservationMap;

    public ReservationService() {
        this.reservationMap = new HashMap<>();
    }

    public Reservation createReservation(String guestId, String roomId, Long checkedIdDate, Long checkedOutDate, double price) {
        Reservation reservation = new Reservation(guestId, roomId, checkedIdDate, checkedOutDate, price);
        reservationMap.put(reservation.getId(), reservation);
        return reservation;
    }

    public Reservation getReservation(String reservationId) {
        return reservationMap.get(reservationId);
    }

    public synchronized void updateReservationStatus(String reservationId, ReservationStatus newStatus) {
        Reservation reservation = reservationMap.get(reservationId);
        reservation.setStatus(newStatus);
    }
}
