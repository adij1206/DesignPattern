package com.aditya.DesignPattern.lld.rummyGame;

import lombok.Data;

@Data
public class Player {

    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public void drawCard(Deck deck) {
        Card card = deck.drawCard();
        hand.addCard(card);
    }

    public void removeCard(Card card) {
        hand.removeCard(card);
    }

    public boolean drawFromDiscardedPile() {
        return Math.random() >0.5;
    }

    public Card chooseCardToDiscard() {
       return hand.getCards().get(0);
    }
}
