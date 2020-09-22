package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author g53735
 */
public interface Model {

    public Deck getGameDeck();

    public Players getPlayer();
    
    public Bank getBank();

    public void beginHandPlayer();

    public void playerDrawCard(Players players);

    public boolean checkScoreLose(Players players);

    public void resetCards(List<Card> hand, Deck gameDeck);
    
    public boolean check21(Players players);
}
