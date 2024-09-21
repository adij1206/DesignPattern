package com.aditya.DesignPattern.lld.snakeAndLadder;

public class Dice {

    private static final Integer MIN_VALUE = 1;
    private static final Integer MAX_VALUE = 6;

    public int roll() {
        return (int) (Math.random() * (MAX_VALUE-MIN_VALUE+1)+MIN_VALUE);
    }
}
