package com.aditya.DesignPattern.lld.musicStreamingService;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Album {

    private String id;
    private String title;
    private String artistId;

    public Album(String title, String artistId) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.artistId = artistId;
    }
}
