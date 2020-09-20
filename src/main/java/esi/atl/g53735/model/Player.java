/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g53735.model;

import esi.atl.g53735.cards.Card;
import esi.atl.g53735.cards.Deck;

/**
 *
 * @author g53735
 */
public class Player implements Model {

    Deck deck;

    public Player(Deck deck) {
        this.deck = deck;
    }

    public void startPlayer(Deck gameDeck, Card card) {
        this.deck.getList().add(card);
        gameDeck.getList().remove(card);
        this.deck.getList().add(gameDeck.getList().get(0));
        gameDeck.getList().remove(0);
    }

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public boolean keepGoing(Boolean yesOrNo, Deck gameDeck) {
        if (yesOrNo == true) {
            this.deck.getList().add(gameDeck.getList().get(0));
            gameDeck.getList().remove(0);
            return true;
        }
        return false;
    }
}
