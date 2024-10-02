package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class ShowService {

    Map<String, Show> showMap;

    public ShowService() {
        showMap = new HashMap<>();
    }

    public void addShow(Show show) {
        showMap.put(show.getId(), show);
    }

    public Show getShowById(String id) {
        return showMap.get(id);
    }
}
