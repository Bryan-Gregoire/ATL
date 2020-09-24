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

    public boolean checkAbove21(Players players);

    public void resetCards(List<Card> hand, Deck gameDeck);

    public boolean checkIs21(Players players);

    public void winGold();

    public void loseGold();

    public int getGold();

    public void setBet(int bet);
    
    public int getBet();
    
    public void resetScore();
}
