package com.aditya.DesignPattern.lld.cricInfo;

import lombok.Data;

import java.util.ArrayList;
import java.util.UUID;

@Data
public class Team {

    private String id;
    private String name;

    public Team(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
