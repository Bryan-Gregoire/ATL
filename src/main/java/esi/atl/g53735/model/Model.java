package esi.atl.g53735.model;

import esi.atl.g53735.cards.Card;
import esi.atl.g53735.cards.Deck;

/**
 *
 * @author g53735
 */
public interface Model {
    
    
    Deck getDeck();
    
    boolean keepGoing(Boolean yesOrNo, Deck gameDeck);
}
