package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.HashMap;
import java.util.Map;

public class RestaurantService {

    private Map<String, Restaurant> restaurants;

    public RestaurantService() {
        restaurants = new HashMap<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Restaurant getRestaurantById(String id) {
        return restaurants.get(id);
    }
}
