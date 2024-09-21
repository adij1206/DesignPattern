package com.aditya.DesignPattern.lld.snakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final Integer boardSize = 100;

    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board() {
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();

        initializeSnakesAndLadderInBoard();
    }

    private void initializeSnakesAndLadderInBoard() {
        // Initializing Snakes
        Snake snake1 = new Snake(46, 16);
        Snake snake2 = new Snake(84, 28);
        Snake snake3 = new Snake(94, 75);
        Snake snake4 = new Snake(24, 3);

        snakes.add(snake1);
        snakes.add(snake2);
        snakes.add(snake3);
        snakes.add(snake4);

        // Initializing Ladder
        Ladder ladder1 = new Ladder(20, 42);
        Ladder ladder2 = new Ladder(9, 29);
        Ladder ladder3 = new Ladder(26, 86);
        Ladder ladder4 = new Ladder(58, 77);

        ladders.add(ladder1);
        ladders.add(ladder2);
        ladders.add(ladder3);
        ladders.add(ladder4);
    }

    public int getPositionAfterSnakeAndLadder(int position) {
        for (Snake snake : snakes) {
            if (snake.getStart() == position) {
                return snake.getEnd();
            }
        }

        for (Ladder ladder : ladders) {
            if (ladder.getStart() == position) {
                return ladder.getEnd();
            }
        }

        return position;
    }

    public Integer getBoardSize() {
        return boardSize;
    }
}
