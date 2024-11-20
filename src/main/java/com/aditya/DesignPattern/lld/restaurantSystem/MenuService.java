package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuService {

    private Map<String, Menu> menuMap;
    private Map<String, MenuItem> menuItemMap;
    private Map<String, AddOnItem> addOnItemMap;

    public MenuService() {
        menuMap = new HashMap<>();
        menuItemMap = new HashMap<>();
        addOnItemMap = new HashMap<>();
    }

    public void addMenu(Menu menu) {
        menuMap.put(menu.getRestaurantId(), menu);
    }

    public Menu getMenu(String restaurantId) {
        return menuMap.get(restaurantId);
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItemMap.put(menuItem.getId(), menuItem);
    }

    public MenuItem getMenuItem(String menuItemId) {
        return menuItemMap.get(menuItemId);
    }

    public List<MenuItem> getAvailableMenuItem(String menuId) {
        List<MenuItem> availableMenuItems = new ArrayList<>();

        for (MenuItem menuItem : menuItemMap.values()) {
            if (menuItem.getMenuId().equals(menuId) && menuItem.getAvailable()) {
                availableMenuItems.add(menuItem);
            }
        }

        return availableMenuItems;
    }

    public List<MenuItem> getMenuItemsByMenuId(String menuId) {
        List<MenuItem> availableMenuItems = new ArrayList<>();

        for (MenuItem menuItem : menuItemMap.values()) {
            if (menuItem.getMenuId().equals(menuId)) {
                availableMenuItems.add(menuItem);
            }
        }

        return availableMenuItems;
    }

    public void updateMenuItemAvailability(String menuItemID, boolean availability) {
        MenuItem menuItem = menuItemMap.get(menuItemID);
        menuItem.setAvailable(availability);
    }

    public void updateAddOnItemAvailability(String addOnsId, boolean availability) {
        AddOnItem addOnItem = addOnItemMap.get(addOnsId);
        addOnItem.setAvailable(availability);
    }

    public List<AddOnItem> getAvailableAddOnItem(String menuItemId) {
        List<AddOnItem> availableAddOnItems = new ArrayList<>();

        for (AddOnItem addOnItem : addOnItemMap.values()) {
            if (addOnItem.getMenuItemId().equals(menuItemId) && addOnItem.getAvailable()) {
                availableAddOnItems.add(addOnItem);
            }
        }

        return availableAddOnItems;
    }

    public List<AddOnItem> getAddOnItem(String menuItemId) {
        List<AddOnItem> availableAddOnItems = new ArrayList<>();

        for (AddOnItem addOnItem : addOnItemMap.values()) {
            if (addOnItem.getMenuItemId().equals(menuItemId)) {
                availableAddOnItems.add(addOnItem);
            }
        }

        return availableAddOnItems;
    }

    public void addAddOnItem(AddOnItem addOnItem) {
        addOnItemMap.put(addOnItem.getId(), addOnItem);
    }

}
