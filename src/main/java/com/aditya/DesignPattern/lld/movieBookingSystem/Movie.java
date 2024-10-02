package com.aditya.DesignPattern.lld.movieBookingSystem;

import lombok.Data;

import java.util.UUID;

@Data
public class Movie {

    private String id;
    private String title;
    private int durationInMinutes;

    public Movie(String title, int durationInMinutes) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }
}
