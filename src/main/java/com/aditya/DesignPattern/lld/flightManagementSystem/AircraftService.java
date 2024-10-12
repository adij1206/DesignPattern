package com.aditya.DesignPattern.lld.flightManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class AircraftService {

    private Map<String, AirCraft> airCraftMap;

    public AircraftService() {
        this.airCraftMap = new HashMap<>();
    }

    public void addAircraft(AirCraft airCraft) {
        this.airCraftMap.put(airCraft.getAircraftId(), airCraft);
    }

    public AirCraft getAircraft(String aircraftId) {
        return this.airCraftMap.get(aircraftId);
    }
}
