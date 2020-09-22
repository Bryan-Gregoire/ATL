package esi.atl.g53735.view;

import esi.atl.g53735.model.Card;
import esi.atl.g53735.model.Deck;
import java.util.List;

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
    public void displayPlayerCards(List playerDeck); 
    
    /**
     * Display the score of the player.
     * 
     * @param score the score.
     */
    public void displayScore(int score);
    
    public void displayWallet(int gold);
    
    /**
     * Ask yes or no.
     * 
     * @param message the given message.
     * @return True if yes else false if no.
     */
    public boolean askYesOrNo(String message);
    
    /**
     * Ask if want to draw an other card.
     * 
     * @return true if want a card else false.
     */
    public boolean askTakeCard();
    
    /**
     * Display the possible gain.
     * 
     * @param gold the gold.
     */
    public void displayPossibleGain(int gold);
    
    /**
     * Display the message of the error.
     * 
     * @param errorMessage the message to display.
     */
    public void displayError(String errorMessage);
    
    /**
     * Ask how much the player want to bet.
     * 
     * @param message Display the given message.
     * @return the given integer.
     */
    public int askBet();
    
}
