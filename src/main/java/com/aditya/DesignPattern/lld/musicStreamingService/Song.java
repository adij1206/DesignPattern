package com.aditya.DesignPattern.lld.musicStreamingService;

import lombok.Data;

import java.util.UUID;

@Data
public class Song {

    private String id;
    private String name;
    private String artistId;
    private String albumId;

    public Song(String name, String artistId, String albumId) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.artistId = artistId;
        this.albumId = albumId;
    }
}
