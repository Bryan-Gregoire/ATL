package esi.atl.g53735.model;

import java.util.List;

/**
 * Player of the game.
 *
 * @author Utilisateur
 */
public abstract class Players {

    private List<Card> hand;
    private int score;

    /**
     * Constructor of Players.
     *
     * @param hand The cards of the player.
     * @param score The score of the player.
     */
    public Players(List<Card> hand, int score) {
        this.hand = hand;
        this.score = score;
    }

    /**
     * Get the cards of the player.
     *
     * @return the cards.
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     * Get the score of the player.
     *
     * @return the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Reset the score of the player.
     */
    public void resetScore() {
        this.score = 0;
    }

    /**
     * Draw a card of the game deck and places it in the player's hand.
     *
     * @param gameDeck the deck of the game.
     */
    public void takeCard(Deck gameDeck) {
        Card takenCard = gameDeck.hit();
        this.hand.add(takenCard);
        this.score += takenCard.valueOfCard(takenCard.getValue());
    }
}
