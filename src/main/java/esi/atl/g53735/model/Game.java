/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author g53735
 */
public class Game implements Model {

    private Players players;
    private Bank bank;
    private Deck gameDeck;

    @Override
    public Deck getGameDeck() {
        return this.gameDeck;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public Players getPlayer() {
        return this.players;
    }

    @Override
    public void beginHandPlayer() {
        players.takeCard(this.gameDeck);
        players.takeCard(this.gameDeck);
    }

    @Override
    public void playerDrawCard() {
        players.takeCard(this.gameDeck);
    }

    @Override
    public boolean checkPlayerLose() {
        return players.getScore() > 21;
    }
    
    public boolean check21() {
       return this.players.getScore() == 21;
    }
    
    @Override
    public void resetCards(List<Card> hand, Deck gameDeck) {
        for (int i = hand.size()-1; i > 0; i--) {
            Card card = hand.remove(i);
            gameDeck.getList().add(card);
        }
    }
}
