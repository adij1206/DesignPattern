package com.aditya.DesignPattern.lld.flightManagementSystem;


import java.util.List;

public class FlightManagementSystem {

    private UserService userService;
    private AircraftService aircraftService;
    private FlightService flightService;
    private SeatService seatService;
    private BookingService bookingService;

    public FlightManagementSystem() {
        userService = new UserService();
        aircraftService = new AircraftService();
        flightService = new FlightService();
        seatService = new SeatService();
        bookingService = new BookingService();
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUSer(String id) {
        return userService.getUSer(id);
    }

    public void addAircraft(AirCraft airCraft) {
        aircraftService.addAircraft(airCraft);
    }

    public AirCraft getAirCraft(String airCraftId) {
        return aircraftService.getAircraft(airCraftId);
    }


    public synchronized void addFlight(Flight flight) {
        flightService.addFlight(flight);
    }

    public Flight getFlight(String flightId) {
        return flightService.getFlight(flightId);
    }

    public List<Flight> getAllFlightsBySource(String source) {
        return flightService.getAllFlightsBySource(source);
    }

    public List<Flight> getAllFlightsByDestination(String destination) {
        return flightService.getAllFlightsByDestination(destination);
    }

    public void addSeat(Seat seat) {
        seatService.addSeat(seat);
    }

    public Seat getSeat(String seatNumber, String aircraftIf) {
        return seatService.getSeat(seatNumber, aircraftIf);
    }

    public List<Seat> getAllAvailableSeats(String flightId) {
        Flight flight = flightService.getFlight(flightId);

        return seatService.getAllAvailableSeats(flight.getAircraftId());
    }

    public synchronized Booking createBooking(String flightId, String seatNumber, String passengerId) {
        Flight flight = flightService.getFlight(flightId);

        Seat seat = seatService.getSeat(seatNumber, flight.getAircraftId());

        if (seat.getStatus().equals(SeatStatus.BOOKED)) {
            System.out.println("Seat is already reserved, please select other seat!");
            return null;
        }

        double price = calculatePrice(seat);

        Booking booking = new Booking(flightId, passengerId, seatNumber, price);
        bookingService.addBooking(booking);
        seatService.updateSeatStatus(seat.getId(), SeatStatus.BOOKED);

        return booking;
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookingService.cancelBooking(bookingId);
        Flight flight = flightService.getFlight(booking.getFlightId());
        seatService.updateSeatStatus(booking.getSeatNumber(), flight.getAircraftId(), SeatStatus.AVAILABLE);
    }

    public void updateFlightLanded(String flightId) {
        Flight flight = flightService.getFlight(flightId);
        seatService.updateAllSeatStatusOfAirCraft(flight.getAircraftId());
    }

    private double calculatePrice(Seat seat) {
        switch (seat.getSeatType()) {
            case ECONOMY -> {
                return 1000;
            }
            case BUSINESS -> {
                return 2000;
            }

            case FIRST_CLASS -> {
                return 3000;
            }
        }
        return 0;
    }

    public void doPayment(String bookingId) {
        Booking booking = bookingService.getBookingByBookingId(bookingId);

        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment(bookingId, booking.getPrice());

        bookingService.bookTicket(bookingId);
    }
}
