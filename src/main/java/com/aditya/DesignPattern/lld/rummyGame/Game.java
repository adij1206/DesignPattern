package com.aditya.DesignPattern.lld.rummyGame;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Deck deck;
    private List<Player> players;
    private Table table;
    private int lastPlayerIndex;

    public Game(List<String> playerNames, int noOdDeck) {
        this.deck = new Deck(noOdDeck);
        this.table = new Table();
        this.players = new ArrayList<>();

        for (String playerName : playerNames) {
            this.players.add(new Player(playerName));
        }

        this.lastPlayerIndex = 0;
    }

    public void playGame(int noOfCardsPerPlayer) {
        for (Player player : players) {
            for (int i = 0; i < noOfCardsPerPlayer; i++) {
                player.drawCard(deck);
            }
        }

        while (true) {
            Player player = players.get(lastPlayerIndex);
            System.out.println("Player's Chance : " + player.getName());

            // Player need to decide form where he needs ot pick the card
            Card card = chooseDrawOption(player);
            player.getHand().addCard(card);

            Card cardToBeDiscarded = player.chooseCardToDiscard(); // Here we need to write some algorithm
            player.removeCard(cardToBeDiscarded);

            table.addCardToDiscardedPile(cardToBeDiscarded);

            if (player.getHand().hasValidSetAndSequence()) {
                System.out.println("Player : " + player.getName() + " wins!");
                break;
            }

            lastPlayerIndex = (lastPlayerIndex + 1) % players.size();
        }
    }

    private Card chooseDrawOption(Player player) {
        boolean drawFromDiscardedPile = player.drawFromDiscardedPile();

        if (drawFromDiscardedPile && !table.isEmptyDiscardedPile()) {
            return table.getCardFromDiscardedPile();
        } else {
            return deck.drawCard();
        }
    }
}
