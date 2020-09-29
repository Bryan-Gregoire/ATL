package esi.atl.g53735.model;

import java.util.List;

/**
 * Represent the bank of the game.
 *
 * @author g53735
 */
public class Bank extends Players {

    /**
     * Constructor of bank.
     *
     * @param hand the cards of bank.
     */
    public Bank(List<Card> hand) {
        super(hand, 0);
    }

    /**
     * String represent the bank.
     * 
     * @return the string.
     */
    @Override
    public String toString() {
        return "Bank";
    }
}
