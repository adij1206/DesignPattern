package com.aditya.DesignPattern.lld.musicStreamingService;

import lombok.Data;

import java.util.UUID;

@Data
public class Artist {

    private String id;
    private String name;

    public Artist(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
}
