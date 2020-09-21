/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g53735.model;

import esi.atl.g53735.cards.Deck;

/**
 *
 * @author g53735
 */
public class Game implements Model {

    private Deck deck;
    private Player player;
    private Bot bot;

    @Override
    public Deck getDeck() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keepGoing(Boolean yesOrNo, Deck gameDeck) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
