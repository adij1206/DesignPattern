package com.aditya.DesignPattern.lld.movieBookingSystem;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class Theatre {

    private String id;
    private String name;
    private String location;
    private List<String> showIds;

    public Theatre(String name, String location) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.showIds = new ArrayList<>();
    }

    public void addShowId(String showId) {
        this.showIds.add(showId);
    }
}
