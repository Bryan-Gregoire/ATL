/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g53735.model;

/**
 *
 * @author g53735
 */
public class Game implements Model {

    private Player player;
    private Bank bank;
    private Deck deck;

    @Override
    public Deck getDeck() {
        return this.deck;
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }

    @Override
    public Player getPlayer() {
        return this.player;
    }

    public void takeCard(Boolean takeCard, Deck gameDeck) {
        if (takeCard) {
            player.startHandsPlayer(deck);
        }
    }
}
