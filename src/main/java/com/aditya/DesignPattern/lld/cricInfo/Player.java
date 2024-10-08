package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.UUID;

@Data
public class Player {

    private String id;
    private String name;
    private String role;

    public Player(String name, String role) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.role = role;
    }
}
