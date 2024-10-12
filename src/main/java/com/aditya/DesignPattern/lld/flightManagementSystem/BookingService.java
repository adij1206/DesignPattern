package com.aditya.DesignPattern.lld.flightManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class BookingService {

    private Map<String, Booking> bookings;

    public BookingService() {
        bookings = new HashMap<>();
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public Booking getBookingByBookingId(String bookingId) {
        return bookings.get(bookingId);
    }

    public Booking cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        booking.setStatus(BookingStatus.CANCELED);

        return booking;
    }

    public void bookTicket(String bookingId) {
        Booking booking = bookings.get(bookingId);
        booking.setStatus(BookingStatus.BOOKED);
    }
}
