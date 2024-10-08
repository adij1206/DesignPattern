package com.aditya.DesignPattern.lld.musicStreamingService;

public class Demo {

    public static void main(String[] args) {
        // Create User
        User user1 = new User("abc@gmail.com", "1245");
        User user2 = new User("abd@gmail.com", "1245");

        // Create Artist
        Artist artist1 = new Artist("Artist1");
        Artist artist2 = new Artist("Artist2");

        // Create Album
        Album album1 = new Album("Hero", artist1.getId());
        Album album2 = new Album("Hero2", artist2.getId());

        // Create Song
        Song song1 = new Song("Song1", artist1.getId(), album1.getId());
        Song song3 = new Song("Song3", artist1.getId(), album1.getId());
        Song song2 = new Song("Song2", artist2.getId(), album2.getId());
        Song song4 = new Song("Song4", artist2.getId(), album2.getId());

        MusicStreamService musicStreamService = new MusicStreamService();
        musicStreamService.addUser(user1);
        musicStreamService.addUser(user2);

        musicStreamService.addArtist(artist1);
        musicStreamService.addArtist(artist2);

        musicStreamService.addAlbum(album1);
        musicStreamService.addAlbum(album2);

        musicStreamService.addSong(song1);
        musicStreamService.addSong(song2);
        musicStreamService.addSong(song3);
        musicStreamService.addSong(song4);

        boolean b = musicStreamService.validateUser(user1.getId(), user1.getPassword());
        if (!b) {
            System.out.println("User is not validated");
        }

        System.out.println(musicStreamService.searchByName("Song1"));
        System.out.println(musicStreamService.searchByName(album1.getId()));
        System.out.println(musicStreamService.searchByName(artist1.getId()));

        Playlist playlist = musicStreamService.createPlaylist(user1.getId());
        System.out.println(playlist);

        musicStreamService.addSongInPlaylist(playlist.getId(), song1.getId());
        musicStreamService.addSongInPlaylist(playlist.getId(), song2.getId());

        System.out.println(musicStreamService.getPlaylistByUserId(user1.getId()));
        System.out.println(musicStreamService.getPlaylistSongByPlaylistId(playlist.getId()));

        MusicPlayer player = new MusicPlayer();
        player.play(song1);
        player.seekTo(100);
        player.pause();
    }
}
