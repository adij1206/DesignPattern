package com.aditya.DesignPattern.lld.musicStreamingService;

import lombok.Data;

import java.util.UUID;

@Data
public class PlaylistSong {

    private String id;
    private String playListId;
    private String songId;

    public PlaylistSong(String playListId, String songId) {
        this.id = UUID.randomUUID().toString();
        this.playListId = playListId;
        this.songId = songId;
    }
}
