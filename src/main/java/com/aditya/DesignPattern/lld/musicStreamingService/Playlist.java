package com.aditya.DesignPattern.lld.musicStreamingService;

import lombok.Data;

import java.util.UUID;

@Data
public class Playlist {

    private String id;
    private String userId;

    public Playlist(String userId) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
    }
}
