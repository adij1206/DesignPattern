package com.aditya.DesignPattern.lld.musicStreamingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MusicLibrary {

    private static MusicLibrary instance;
    private Map<String, Song> songMap;
    private Map<String, Album> albumMap;
    private Map<String, Artist> artistMap;

    private MusicLibrary() {
        this.albumMap = new HashMap<>();
        this.artistMap = new HashMap<>();
        this.songMap = new HashMap<>();
    }

    public synchronized static MusicLibrary getInstance() {
        if (instance == null) {
             instance = new MusicLibrary();
        }

        return instance;
    }

    public void addSong(Song song) {
        this.songMap.put(song.getId(), song);
    }


    public void addAlbum(Album album) {
        this.albumMap.put(album.getId(), album);
    }


    public void addArtist(Artist artist) {
        this.artistMap.put(artist.getId(), artist);
    }

    public Song getSongById(String id) {
        return songMap.get(id);
    }


    public Album getAlbumById(String id) {
        return albumMap.get(id);
    }

    public Artist getArtistById(String artistId) {
        return artistMap.get(artistId);
    }

    public List<Album> getAlbumListByArtistId(String artistId) {
        List<Album> albums = new ArrayList<>();

        for (Album album : albumMap.values()) {
            if (album.getArtistId().equals(artistId)) {
                albums.add(album);
            }
        }

        return albums;
    }

    public List<Song> searchByName(String query) {
        List<Song> songs = new ArrayList<>();

        for (Song song : songMap.values()) {
            if (song.getName().contains(query) || song.getAlbumId().equals(
                    query) || song.getArtistId().equals(query)) {
                songs.add(song);
            }
        }

        return songs;
    }

}
