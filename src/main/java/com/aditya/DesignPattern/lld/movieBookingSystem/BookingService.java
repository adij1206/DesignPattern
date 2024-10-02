package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

    private Map<String, Booking> stringBookingMap;

    public BookingService() {
        stringBookingMap = new HashMap<>();
    }

    public void addBooking(Booking booking) {
        stringBookingMap.put(booking.getId(), booking);
    }

    public Booking getBookingById(String id) {
        return stringBookingMap.get(id);
    }
}
