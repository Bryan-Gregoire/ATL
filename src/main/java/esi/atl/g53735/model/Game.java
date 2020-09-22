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

    private Player player;
    private Bank bank;
    private Deck gameDeck;
    
    @Override
    public Deck getGameDeck() {
        return this.gameDeck;
    }

    @Override
    public Player getPlayer() {
        return player;
    }
    
    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public void beginHandPlayer() {
        player.takeCard(this.gameDeck);
        player.takeCard(this.gameDeck);
    }

    @Override
    public void playerDrawCard(Players players) {
        players.takeCard(this.gameDeck);
    }

    @Override
    public boolean checkScoreLose(Players players) {
        return players.getScore() > 21;
    }
    
    @Override
    public boolean check21(Players players) {
       return players.getScore() == 21;
    }
    
    @Override
    public void resetCards(List<Card> hand, Deck gameDeck) {
        for (int i = hand.size()-1; i > 0; i--) {
            Card card = hand.remove(i);
            gameDeck.getList().add(card);
        }
    }
}
