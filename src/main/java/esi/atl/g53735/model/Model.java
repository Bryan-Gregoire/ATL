package esi.atl.g53735.model;

import esi.atl.g53735.cards.Deck;

/**
 *
 * @author g53735
 */
public interface Model {

    Deck getDeck();

    void keepGoing(Boolean yesOrNo, Deck gameDeck);
}
