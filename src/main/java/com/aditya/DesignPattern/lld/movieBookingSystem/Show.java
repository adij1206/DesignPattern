package com.aditya.DesignPattern.lld.movieBookingSystem;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Show {

    private String id;
    private String theatreId;
    private String movieId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Seat> seatMap;

    public Show(
            String theatreId, String movieId, LocalDateTime startTime, LocalDateTime endTime, List<Seat> seatMap
    ) {
        this.id = UUID.randomUUID().toString();
        this.theatreId = theatreId;
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seatMap = seatMap;
    }
}
