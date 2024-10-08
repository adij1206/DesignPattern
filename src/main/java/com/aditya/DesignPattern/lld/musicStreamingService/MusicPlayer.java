package com.aditya.DesignPattern.lld.musicStreamingService;

public class MusicPlayer {

    private Song song;
    private int currentTime;
    private boolean isPlaying;

    public MusicPlayer() {}

    public void pause() {
        this.isPlaying = false;
        System.out.println("PAusing song!");
    }

    public void play(Song song) {
        this.song = song;
        this.isPlaying = true;
        currentTime = 0;
        System.out.println("Playing song!");
    }

    public void seekTo(int time) {
        this.currentTime = time;
        System.out.println("Seeking to time!" + time);
    }
}
