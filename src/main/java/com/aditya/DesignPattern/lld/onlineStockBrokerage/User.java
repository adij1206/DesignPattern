package com.aditya.DesignPattern.lld.onlineStockBrokerage;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private String accountId;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
