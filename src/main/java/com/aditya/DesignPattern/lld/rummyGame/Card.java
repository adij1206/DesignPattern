package com.aditya.DesignPattern.lld.rummyGame;

import lombok.Data;

@Data
public class Card {

    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
}
