package com.aditya.DesignPattern.lld.rummyGame;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
public class Deck {

    private static final List<String> suits = Arrays.asList("DIAMONDS", "CLUBS", "HEARTS", "SPADES");
    private static final List<String> ranks = Arrays.asList(
            "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");

    private List<Card> cards;

    public Deck(int noOfDeck) {
        this.cards = new ArrayList<>(noOfDeck);

        for (int i=0;i<noOfDeck;i++) {
            for (String suit : suits) {
                for (String rank : ranks) {
                    cards.add(new Card(suit, rank));
                }
            }
        }

        Collections.shuffle(cards);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card drawCard() {
        return cards.remove(cards.size()-1);
    }
}
