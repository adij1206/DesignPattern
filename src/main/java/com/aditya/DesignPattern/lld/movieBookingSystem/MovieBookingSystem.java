package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.util.List;

public class MovieBookingSystem {

    /*
     * Added synchronised in the method as booking can be done for same ticket by various user,
     * so only one user can make booking we have added the keyword
     */
    private static MovieBookingSystem instance;
    private BookingService bookingService;
    private UserService userService;
    private TheatreService theatreService;
    private ShowService showService;
    private MovieService movieService;

    private MovieBookingSystem() {
        bookingService = new BookingService();
        userService = new UserService();
        theatreService = new TheatreService();
        showService = new ShowService();
        movieService = new MovieService();
    }

    public static synchronized MovieBookingSystem getInstance() {
        if (instance == null) {
            instance = new MovieBookingSystem();
        }

        return instance;
    }

    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
    }

    public void addShow(Show show) {
        showService.addShow(show);
    }

    public void addTheatre(Theatre theatre) {
        theatreService.addTheatre(theatre);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public void addShowInTheatre(String showId, String theatreId) {
        theatreService.addShowId(showId, theatreId);
    }

    public synchronized Booking bookTicket(String userId, String showId, List<String> seatIds) {
        Show showById = showService.getShowById(showId);
        if (checkIfSeatAvailable(showById, seatIds)) {
            markSeatAsBooked(showById, seatIds);

            double totalPrice = calculateTotalPrice(showById, seatIds);
            Booking booking = new Booking(totalPrice, seatIds, userId, showId);
            bookingService.addBooking(booking);

            return booking;
        }

        return null;
    }

    public synchronized void confirmBooking(String bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);

        if (booking!=null && booking.getStatus().equals(BookingStatus.CREATED.name())) {
            booking.setStatus(BookingStatus.CONFIRMED.name());
        }
    }

    public synchronized void cancelBooking(String bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);

        if (booking!=null && !booking.getStatus().equals(BookingStatus.CANCELLED.name())) {
            booking.setStatus(BookingStatus.CANCELLED.name());
            markSeatAsAvailable(booking.getShowId(), booking.getSeatIds());
        }
    }

    private void markSeatAsAvailable(String showId, List<String> seatIds) {
        Show show = showService.getShowById(showId);

        for (Seat seat : show.getSeatMap()) {
            if (seatIds.contains(seat.getId())) {
                seat.setStatus(SeatStatus.AVAILABLE.name());
            }
        }
    }

    private double calculateTotalPrice(Show showById, List<String> seatIds) {
        double amount = 0.0;

        for (Seat seat : showById.getSeatMap()) {
            if (seatIds.contains(seat.getId())) {
                amount += seat.getPrice();
            }
        }

        return amount;
    }

    private void markSeatAsBooked(Show showById, List<String> seatIds) {
        for (Seat seat : showById.getSeatMap()) {
            if (seatIds.contains(seat.getId())) {
                seat.setStatus(SeatStatus.BOOKED.name());
            }
        }
    }

    private boolean checkIfSeatAvailable(Show show, List<String> seatIds) {

        for (Seat seat : show.getSeatMap()) {
            if (seatIds.contains(seat.getId()) && !seat.getStatus().equals(SeatStatus.AVAILABLE.name())) {
                return false;
            }
        }

        return true;
    }

}
