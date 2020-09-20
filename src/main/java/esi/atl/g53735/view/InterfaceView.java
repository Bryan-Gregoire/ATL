package esi.atl.g53735.view;

import esi.atl.g53735.cards.Deck;

/**
 *
 * @author Utilisateur
 */
public interface InterfaceView {
    
    /**
     * Display the given message.
     * 
     * @param message the given message to display. 
     */
    public void displayMessage(String message);
    
    /**
     * Display player cards.
     * 
     * @param playerDeck player cards. 
     */
    public void displayPlayerDeck(Deck playerDeck);
}
