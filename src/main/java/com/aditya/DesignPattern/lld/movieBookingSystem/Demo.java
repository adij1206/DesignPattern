package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p> The system should allow users to view the list of movies playing in different theaters. <p>
 * <p>Users should be able to select a movie, theater, and show timing to book tickets.<p>
 * <p>The system should display the seating arrangement of the selected show and allow users to choose seats.<p>
 * <p>Users should be able to make payments and confirm their booking.<p>
 * <p>The system should handle concurrent bookings and ensure seat availability is updated in real-time.<p>
 * <p>The system should support different types of seats (e.g., normal, premium) and pricing.<p>
 * <p>The system should allow theater administrators to add, update, and remove movies, shows, and seating arrangements.<p>
 * <p>The system should be scalable to handle a large number of concurrent users and bookings.<p>
 */

public class Demo {

    public static void main(String[] args) {
        // Create Movie
        Movie movie1 = new Movie("Don", 120);
        Movie movie2 = new Movie("Don2", 140);

        // Create Theatre
        Theatre theatre1 = new Theatre("PVR", "Brookefield");
        Theatre theatre2 = new Theatre("INOX", "Brookefield");

        // Creating Show
        Show show1 = new Show(
                theatre1.getId(),
                movie1.getId(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()),
                createSeat(6, 10)
        );

        Show show2 = new Show(
                theatre2.getId(),
                movie2.getId(),
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(movie1.getDurationInMinutes()),
                createSeat(8, 8)
        );

        MovieBookingSystem movieBookingSystem = MovieBookingSystem.getInstance();
        movieBookingSystem.addMovie(movie1);
        movieBookingSystem.addMovie(movie2);

        movieBookingSystem.addShow(show1);
        movieBookingSystem.addShow(show2);

        movieBookingSystem.addTheatre(theatre1);
        movieBookingSystem.addTheatre(theatre2);

        movieBookingSystem.addShowInTheatre(show1.getId(), theatre1.getId());
        movieBookingSystem.addShowInTheatre(show2.getId(), theatre2.getId());

        User user = new User("Aditya");
        movieBookingSystem.addUser(user);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> seatIds = Arrays.asList("1-5", "4-5");
                Booking booking = movieBookingSystem.bookTicket(user.getId(), show1.getId(), seatIds);

                if (booking != null) {
                    System.out.println("Booking Successful" + booking.getId());
                    movieBookingSystem.confirmBooking(booking.getId());
                } else {
                    System.out.println("Booking Failed as seat are not available");
                }
            }
        });

        Thread thread2 = new  Thread(new Runnable() {
            @Override
            public void run() {
                List<String> seatIds = Arrays.asList("1-5", "4-5");
                Booking booking = movieBookingSystem.bookTicket(user.getId(), show1.getId(), seatIds);

                if (booking!=null) {
                    System.out.println("Booking Successful" + booking.getId());
                    movieBookingSystem.confirmBooking(booking.getId());
                } else {
                    System.out.println("Booking Failed as seat are not available");
                }
            }
        });

        thread1.start();
        thread2.start();


        //movieBookingSystem.cancelBooking(booking.getId());
    }

    private static List<Seat> createSeat(int row, int column) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String seatId = i + "-" + j;
                SeatType seatType = (row <= 2) ? SeatType.PREMIUM : SeatType.NORMAL;
                double price = (seatType == SeatType.PREMIUM) ? 150.0 : 100.0;

                Seat seat = new Seat(seatId, i, j, price, seatType.name(), SeatStatus.AVAILABLE.name());
                seats.add(seat);
            }
        }

        return seats;
    }
}
