package com.aditya.DesignPattern.lld.rummyGame;

import java.util.ArrayList;
import java.util.List;

public class Table {

   private List<Card> discardedCards;

    public Table() {
        this.discardedCards = new ArrayList<>();
    }

    public void addCardToDiscardedPile(Card card) {
        discardedCards.add(card);
    }

    public Card getCardFromDiscardedPile() {
        return discardedCards.remove(discardedCards.size() - 1);
    }

    public boolean isEmptyDiscardedPile() {
        return discardedCards.isEmpty();
    }
}
