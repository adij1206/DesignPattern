package com.aditya.DesignPattern.lld.ticTacToe;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private Piece[][] pieces;

    public static class Pair {

        private Integer first;
        private Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public Integer getFirst() {
            return first;
        }

        public void setFirst(Integer first) {
            this.first = first;
        }

        public Integer getSecond() {
            return second;
        }

        public void setSecond(Integer second) {
            this.second = second;
        }
    }

    public Board(int size) {
        this.size = size;
        pieces = new Piece[size][size];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pieces[i][j] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(pieces[i][j].getPieceType().name());
                }

                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public boolean addPiece(int row, int col, Piece piece) {
        if (pieces[row][col] != null) {
            return false;
        }

        pieces[row][col] = piece;
        return true;
    }

    public List<Pair> getFreeCells() {
        List<Pair> freeCells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (pieces[i][j] == null) {
                    Pair pair = new Pair(i, j);
                    freeCells.add(pair);
                }
            }
        }

        return freeCells;
    }
}
