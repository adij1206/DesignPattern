package com.aditya.DesignPattern.lld.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class SnakeAndLadderGame {

    private List<Player> players;
    private Integer currentPlayerIndex;
    private Board board;
    private Dice dice;

    public SnakeAndLadderGame(List<String> playerNames) {
        board = new Board();
        dice = new Dice();
        currentPlayerIndex = 0;

        players = new ArrayList<>();

        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
    }

    public void play() {
        while (!isGameOver()) {
            Player player = players.get(currentPlayerIndex);

            int diceRoll = dice.roll();
            int newPosition = diceRoll + player.getPosition();

            if (newPosition <= board.getBoardSize()) {
                player.setPosition(board.getPositionAfterSnakeAndLadder(newPosition));
                System.out.println("PLayer " + player.getName() + " new position is " + player.getPosition());
            }

            if (player.getPosition() == board.getBoardSize()) {
                System.out.println("Game Over! Player " + player.getName() + " won!");
                break;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private boolean isGameOver() {
        for (Player player : players) {
            if (player.getPosition().equals(board.getBoardSize())) {
                return true;
            }
        }

        return false;
    }
}
