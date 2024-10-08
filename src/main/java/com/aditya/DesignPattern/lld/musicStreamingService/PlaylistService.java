package com.aditya.DesignPattern.lld.musicStreamingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaylistService {

    private Map<String, Playlist> playlistMap;
    private Map<String, PlaylistSong> playlistSongMap;

    public PlaylistService() {
        this.playlistMap = new HashMap<>();
        this.playlistSongMap = new HashMap<>();
    }

    public Playlist createPlaylist(String userId) {
        Playlist playlist = new Playlist(userId);
        playlistMap.put(playlist.getId(), playlist);
        return playlist;
    }

    public Playlist getPlaylistById(String playlistId) {
        return playlistMap.get(playlistId);
    }

    public List<Playlist> getPlaylistByUserId(String userId) {
        List<Playlist> playlists = new ArrayList<>();

        for (Playlist playlist : playlistMap.values()) {
            if (playlist.getUserId().equals(userId)) {
                playlists.add(playlist);
            }
        }

        return playlists;
    }

    public PlaylistSong addSongInPlaylist(String playlistId, String songId) {
        PlaylistSong song = new PlaylistSong(playlistId, songId);
        playlistSongMap.put(song.getId(), song);
        return song;
    }

    public PlaylistSong getPlaylistSongById(String playlistSongId) {
        return playlistSongMap.get(playlistSongId);
    }

    public List<PlaylistSong> getPlaylistSongByPlaylistId(String playlistId) {
        List<PlaylistSong> playlistSongs = new ArrayList<>();

        for (PlaylistSong playlistSong : playlistSongMap.values()) {
            if (playlistSong.getPlayListId().equals(playlistId)) {
                playlistSongs.add(playlistSong);
            }
        }

        return playlistSongs;
    }
}
