package com.aditya.DesignPattern.lld.rummyGame;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        Game game = new Game(Arrays.asList("Aditya", "Manish", "paras"), 2);

        game.playGame(10);

    }
}
