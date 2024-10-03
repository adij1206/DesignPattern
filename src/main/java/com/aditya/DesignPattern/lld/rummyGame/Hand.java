package com.aditya.DesignPattern.lld.rummyGame;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Hand {

    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    public boolean hasValidSetAndSequence() {
        // need to write the logic

        return false;
    }
}
