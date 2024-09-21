package com.aditya.DesignPattern.lld.snakeAndLadder;

import java.util.Arrays;
import java.util.List;

public class SnakeAndLadderDemo {

    public static void main(String[] args) throws InterruptedException {
        GameManager gameManager = GameManager.getInstance();

        List<String> firstGamePlayerList = Arrays.asList("Aditya", "Abhigyan", "Satyam", "Sourabh");
        gameManager.startGame(firstGamePlayerList);

        List<String> secondGamePlayerList = Arrays.asList("Aditya", "Paras", "Manish");
        gameManager.startGame(secondGamePlayerList);

        System.out.println(gameManager.getNoOfGamesCurrentlyPlayed());
    }
}
