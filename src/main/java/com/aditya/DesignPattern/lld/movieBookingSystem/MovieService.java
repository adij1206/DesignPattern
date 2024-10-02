package com.aditya.DesignPattern.lld.movieBookingSystem;

import java.util.HashMap;
import java.util.Map;

public class MovieService {

    private Map<String, Movie> movieMap;

    public MovieService() {
        this.movieMap = new HashMap<>();
    }

    public void addMovie(Movie movie) {
        this.movieMap.put(movie.getId(), movie);
    }

    public Movie getMovie(String id) {
        return this.movieMap.get(id);
    }
}
