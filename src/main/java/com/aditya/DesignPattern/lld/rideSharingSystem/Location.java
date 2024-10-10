package com.aditya.DesignPattern.lld.rideSharingSystem;

import lombok.Data;

@Data
public class Location {

    private double lat;
    private double lng;

    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
