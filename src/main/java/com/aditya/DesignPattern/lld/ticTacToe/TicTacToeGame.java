package com.aditya.DesignPattern.lld.ticTacToe;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    private Board board;
    private Deque<Player> players;

    public void initializeBoard() {
        this.players = new LinkedList<>();

        PieceX pieceX = new PieceX();
        Player player1 = new Player("Aditya", pieceX);

        PieceO pieceO = new PieceO();
        Player player2 = new Player("Abhigyan", pieceO);

        players.add(player1);
        players.add(player2);

        this.board = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;

        while (noWinner) {
            Player player1 = players.removeFirst();

            // Print the board to have the view for each player before making any move
            board.printBoard();

            List<Board.Pair> freeCells = board.getFreeCells();
            if (freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.println("Player " + player1.getName() + ", Enter the move row,column: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] moves = input.split(",");

            Integer row = Integer.valueOf(moves[0]);
            Integer col = Integer.valueOf(moves[1]);

            boolean addedPiece = board.addPiece(row, col, player1.getPiece());
            if (!addedPiece) {
                System.out.println("Entered Position is not empty to play");
                players.addFirst(player1);
                continue;
            }

            players.addLast(player1);

            boolean winner = checkIfWinner(row, col, player1);
            if (winner) {
                return player1.getName();
            }
        }

        return "tie";
    }

    private boolean checkIfWinner(Integer row, Integer col, Player player1) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean reverseDiagonalMatch = true;

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getPieces()[row][i] == null || !board.getPieces()[row][i].equals(player1.getPiece())) {
                rowMatch = false;
                break;
            }
        }

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getPieces()[i][col] == null || !board.getPieces()[i][col].equals(player1.getPiece())) {
                colMatch = false;
                break;
            }
        }

        for (int i = 0, j = 0; i < board.getSize(); i++, j++) {
            if (board.getPieces()[i][j] == null || !board.getPieces()[i][j].equals(player1.getPiece())) {
                diagonalMatch = false;
                break;
            }
        }

        for (int i = 0, j = board.getSize() - 1; i < board.getSize(); i++, j--) {
            if (board.getPieces()[i][j] == null || !board.getPieces()[i][j].equals(player1.getPiece())) {
                reverseDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || reverseDiagonalMatch;
    }
}
