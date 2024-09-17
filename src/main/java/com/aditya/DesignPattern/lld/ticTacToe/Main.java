package com.aditya.DesignPattern.lld.ticTacToe;

public class Main {

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeBoard();
        String winner = game.startGame();
        System.out.println("Winner is " + winner);
    }
}
