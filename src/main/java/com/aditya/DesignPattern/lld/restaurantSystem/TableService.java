package com.aditya.DesignPattern.lld.restaurantSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableService {

    private Map<String, List<Table>> tables;

    public TableService() {
        tables = new HashMap<>();
    }

    public void addTable(Table table) {
        List<Table> tableList = tables.getOrDefault(table.getRestaurantId(), new ArrayList<>());
        tableList.add(table);
        tables.put(table.getRestaurantId(), tableList);
    }

    public Table getTable(String restaurantId, String tableNumber) {
        for (Table table : tables.get(restaurantId)) {
            if (table.getRestaurantId().equals(restaurantId) && table.getTableNumber().equals(tableNumber)) {
                return table;
            }
        }

        return null;
    }

    public List<Table> getAvailableTables(String restaurantId) {
        List<Table> availableTables = new ArrayList<>();

        for (Table table : tables.get(restaurantId)) {
            if (table.getIsEmpty().equals(Boolean.TRUE)) {
                availableTables.add(table);
            }
        }

        return availableTables;
    }

    public void assignOrderId(String restaurantId, String tableNumber, String orderId) {
        Table table = getTable(restaurantId, tableNumber);
        table.setCurrentOrderId(orderId);
        table.setIsEmpty(false);
    }

    public void updateOrderAndAvailability(String restaurantId, String tableNumber) {
        Table table = getTable(restaurantId, tableNumber);
        table.setIsEmpty(true);
        table.setCurrentOrderId(null);
    }
}
