package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class TheatreService {

    Map<String, Theatre> theatreMap;

    public TheatreService() {
        theatreMap = new HashMap<>();
    }

    public void addTheatre(Theatre theatre) {
        theatreMap.put(theatre.getId(), theatre);
    }

    public Theatre getTheatreById(String theatreId) {
        return theatreMap.get(theatreId);
    }

    public void addShowId(String showId, String theatreId) {
        Theatre theatre = getTheatreById(theatreId);
        theatre.addShowId(showId);
    }
}
