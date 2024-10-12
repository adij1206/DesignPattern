package com.aditya.DesignPattern.lld.flightManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightService {

    private Map<String , Flight> flights;

    public FlightService() {
        flights = new HashMap<>();
    }

    public void addFlight(Flight flight) {
        this.flights.put(flight.getFlightId(), flight);
    }

    public Flight getFlight(String flightId) {
        return this.flights.get(flightId);
    }

    public List<Flight> getAllFlightsBySource(String source) {
        List<Flight> flights = new ArrayList<>();

        for (Flight flight : this.flights.values()) {
            if (flight.getSource().equals(source)) {
                flights.add(flight);
            }
        }

        return flights;
    }

    public List<Flight> getAllFlightsByDestination(String destination) {
        List<Flight> flights = new ArrayList<>();

        for (Flight flight : this.flights.values()) {
            if (flight.getDestination().equals(destination)) {
                flights.add(flight);
            }
        }

        return flights;
    }
}
