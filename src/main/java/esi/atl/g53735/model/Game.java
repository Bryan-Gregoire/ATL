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
    public Player getPlayer() {
        return this.player;
    }

    @Override
    public void beginHandPlayer() {
        player.takeCard(this.gameDeck);
        player.takeCard(this.gameDeck);
    }

    @Override
    public void playerDrawCard() {
        player.takeCard(this.gameDeck);
    }

    @Override
    public boolean checkPlayerLose() {
        return player.getScore() > 21;
    }
}
