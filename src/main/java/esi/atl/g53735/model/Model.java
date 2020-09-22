package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author g53735
 */
public interface Model {

    public Deck getGameDeck();

    public Bank getBank();

    public Players getPlayer();

    public void beginHandPlayer();

    public void playerDrawCard();

    public boolean checkPlayerLose();

    public void resetCards(List<Card> hand, Deck gameDeck);
}
