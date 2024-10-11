package com.aditya.DesignPattern.lld.hotelManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class GuestService {

    private Map<String, Guest> guestMap;

    public GuestService() {
        guestMap = new HashMap<>();
    }

    public void addGuest(Guest guest) {
        guestMap.put(guest.getName(), guest);
    }

    public Guest getGuest(String name) {
        return guestMap.get(name);
    }
}
