package com.aditya.DesignPattern.lld.restaurantSystem;

import lombok.Data;

@Data
public class Table {

    private String tableNumber;
    private String restaurantId;
    private Boolean isEmpty;
    private String currentOrderId;

    public Table(String tableNumber, String restaurantId) {
        this.tableNumber = tableNumber;
        this.restaurantId = restaurantId;
        this.isEmpty = true;
    }
}
