package com.aditya.DesignPattern.lld.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private static GameManager instance;
    private List<SnakeAndLadderGame> snakeAndLadderGameList;

    private GameManager() {
        snakeAndLadderGameList = new ArrayList<>();
    }

    public static synchronized GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }

        return instance;
    }

    public void startGame(List<String> playerNames) {
        SnakeAndLadderGame game = new SnakeAndLadderGame(playerNames);
        snakeAndLadderGameList.add(game);

        new Thread(game::play).start();
    }

    public int getNoOfGamesCurrentlyPlayed() {
        return snakeAndLadderGameList.size();
    }
}
