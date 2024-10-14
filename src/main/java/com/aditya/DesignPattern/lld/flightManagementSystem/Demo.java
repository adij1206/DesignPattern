package com.aditya.DesignPattern.lld.flightManagementSystem;

import java.time.LocalDateTime;

/**
 * The airline management system should allow users to search for flights based on source, destination, and date.
 * Users should be able to book flights, select seats, and make payments.
 * The system should manage flight schedules, aircraft assignments, and crew assignments.
 * The system should handle passenger information, including personal details and baggage information.
 * The system should support different types of users, such as passengers, airline staff, and administrators.
 * The system should be able to handle cancellations, refunds, and flight changes.
 * The system should ensure data consistency and handle concurrent access to shared resources.
 * The system should be scalable and extensible to accommodate future enhancements and new features.
 */
public class Demo {

    public static void main(String[] args) {
        AirCraft airCraft = new AirCraft(5);

        Seat seat1 = new Seat("1", airCraft.getAircraftId(), SeatType.ECONOMY);
        Seat seat2 = new Seat("2", airCraft.getAircraftId(), SeatType.ECONOMY);
        Seat seat3 = new Seat("3", airCraft.getAircraftId(), SeatType.BUSINESS);
        Seat seat4 = new Seat("4", airCraft.getAircraftId(), SeatType.BUSINESS);
        Seat seat5 = new Seat("5", airCraft.getAircraftId(), SeatType.FIRST_CLASS);

        Flight flight = new Flight(
                "London",
                "Delhi",
                LocalDateTime.now().plusDays(1),
                LocalDateTime.now().plusDays(2),
                airCraft.getAircraftId()
        );

        Flight flight1 = new Flight(
                "London",
                "Mumbai",
                LocalDateTime.now().plusDays(3),
                LocalDateTime.now().plusDays(4),
                airCraft.getAircraftId()
        );

        User user = new User("abc@gmail.com", "Adi");
        User user1 = new User("abd@gmail.com", "Adi");

        FlightManagementSystem flightManagementSystem = new FlightManagementSystem();

        flightManagementSystem.addAircraft(airCraft);

        flightManagementSystem.addUser(user1);
        flightManagementSystem.addUser(user);

        flightManagementSystem.addSeat(seat1);
        flightManagementSystem.addSeat(seat2);
        flightManagementSystem.addSeat(seat3);
        flightManagementSystem.addSeat(seat4);
        flightManagementSystem.addSeat(seat5);

        flightManagementSystem.addFlight(flight);
        flightManagementSystem.addFlight(flight1);

        System.out.println("Aircraft " + flightManagementSystem.getAirCraft(airCraft.getAircraftId()));

        System.out.println("Available Flight " + flightManagementSystem.getAllFlightsBySource("London"));

        System.out.println("Available Seats " + flightManagementSystem.getAllAvailableSeats(flight1.getFlightId()));

        Booking booking = flightManagementSystem.createBooking(
                flight1.getFlightId(), seat1.getSeatNumber(), user.getId());
        System.out.println("Booking " + booking);
        flightManagementSystem.doPayment(booking.getBookingId());

        Booking booking1 = flightManagementSystem.createBooking(
                flight1.getFlightId(), seat1.getSeatNumber(), user1.getId());
        System.out.println("Booking " + booking1);

        Booking booking2 = flightManagementSystem.createBooking(
                flight1.getFlightId(), seat4.getSeatNumber(), user1.getId());
        System.out.println("Booking " + booking2);

        System.out.println("Available Seats " + flightManagementSystem.getAllAvailableSeats(flight1.getFlightId()));
        flightManagementSystem.cancelBooking(booking2.getBookingId());
        System.out.println("Available Seats " + flightManagementSystem.getAllAvailableSeats(flight1.getFlightId()));
        flightManagementSystem.updateFlightLanded(flight1.getFlightId());
        System.out.println("Available Seats " + flightManagementSystem.getAllAvailableSeats(flight1.getFlightId()));
    }
}
