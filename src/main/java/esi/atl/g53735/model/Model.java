package esi.atl.g53735.model;

/**
 *
 * @author g53735
 */
public interface Model {

    public Deck getGameDeck();

    public Bank getBank();

    public Player getPlayer();

    public void beginHandPlayer();

    public void playerDrawCard();

    public boolean checkPlayerLose();
}
