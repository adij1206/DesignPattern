package com.aditya.DesignPattern.lld.musicStreamingService;


import java.util.List;

public class MusicStreamService {

    private PlaylistService playlistService;
    private UserService userService;
    private MusicLibrary musicLibrary;

    public MusicStreamService() {
        this.musicLibrary = MusicLibrary.getInstance();
        this.userService = new UserService();
        this.playlistService = new PlaylistService();
    }

    public void addSong(Song song) {
        musicLibrary.addSong(song);
    }

    public void addAlbum(Album album) {
        musicLibrary.addAlbum(album);
    }

    public void addArtist(Artist artist) {
        musicLibrary.addArtist(artist);
    }

    public Song getSongById(String id) {
        return musicLibrary.getSongById(id);
    }

    public Album getAlbumById(String id) {
        return musicLibrary.getAlbumById(id);
    }

    public Artist getArtistById(String artistId) {
        return musicLibrary.getArtistById(artistId);
    }

    public List<Album> getAlbumListByArtistId(String artistId) {
        return musicLibrary.getAlbumListByArtistId(artistId);
    }

    public List<Song> searchByName(String query) {
        return musicLibrary.searchByName(query);
    }

    public void addUser(User user) {
        userService.addUser(user);
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    public boolean validateUser(String id, String password) {
        return userService.validateUser(id, password);
    }

    public Playlist createPlaylist(String userId) {
        return playlistService.createPlaylist(userId);
    }

    public Playlist getPlaylistById(String playlistId) {
        return playlistService.getPlaylistById(playlistId);
    }

    public List<Playlist> getPlaylistByUserId(String userId) {
        return playlistService.getPlaylistByUserId(userId);
    }

    public PlaylistSong addSongInPlaylist(String playlistId, String songId) {
        return playlistService.addSongInPlaylist(playlistId, songId);
    }

    public PlaylistSong getPlaylistSongById(String playlistSongId) {
        return playlistService.getPlaylistSongById(playlistSongId);
    }

    public List<PlaylistSong> getPlaylistSongByPlaylistId(String playlistId) {
        return playlistService.getPlaylistSongByPlaylistId(playlistId);
    }
}
