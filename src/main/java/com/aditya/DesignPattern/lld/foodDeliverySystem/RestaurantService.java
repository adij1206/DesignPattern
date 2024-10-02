package com.aditya.DesignPattern.lld.foodDeliverySystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantService {

    private Map<String, Restaurant> restaurants;
    private Map<String, List<MenuItem>> menuItems;

    public RestaurantService() {
        restaurants = new HashMap<>();
        menuItems = new HashMap<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getId(), restaurant);
    }

    public Restaurant getRestaurantById(String restaurantId) {
        return restaurants.get(restaurantId);
    }

    public List<Restaurant> getAllRestaurant() {
        return new ArrayList<>(restaurants.values());
    }

    public List<MenuItem> getMenuItemByRestaurantId(String restaurantId) {
        return menuItems.get(restaurantId);
    }

    public MenuItem getMenuItemByRestaurantIdAndMenuItemId(String restaurantId, String itemId) {
        List<MenuItem> menuItems = getMenuItemByRestaurantId(restaurantId);
        for (MenuItem menuItem : menuItems) {
            if (menuItem.getId().equals(itemId)) {
                return menuItem;
            }
        }

        return null;
    }

    public List<MenuItem> getSelectedMenuItem(String restaurantId, List<String> itemIds) {
        List<MenuItem> menuItems = getMenuItemByRestaurantId(restaurantId);

        List<MenuItem> selectedMenuItems = new ArrayList<>();
        for (MenuItem menuItem : menuItems) {
            if (itemIds.contains(menuItem.getId())) {
                selectedMenuItems.add(menuItem);
            }
        }

        return selectedMenuItems;
    }

    public void addMenuItemInRestaurant(String restaurantId, MenuItem menuItem) {
        List<MenuItem> menuItems1 = menuItems.getOrDefault(restaurantId, new ArrayList<>());
        menuItems1.add(menuItem);
        menuItems.put(restaurantId, menuItems1);
    }
}
