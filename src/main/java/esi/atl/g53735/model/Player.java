package esi.atl.g53735.model;

import java.util.List;

/**
 * Player of the game.
 *
 * @author g53735
 */
public class Player extends Players {

    private int gold;

    /**
     * Constructor of Player.
     *
     * @param hand the cards of the player.
     */
    public Player(List<Card> hand) {
        super(hand, 0);
        this.gold = 1000;
    }

    /**
     * Get the money of the player.
     *
     * @return the money.
     */
    public int getGold() {
        return gold;
    }

    /**
     * Add the winning bet to the player's money.
     *
     * @param goldWin the money earn.
     */
    public void winGold(int goldWin) {
        this.gold += goldWin;
    }

    /**
     * The player loses the money he has bet.
     *
     * @param goldLose the money lost.
     */
    public void loseGold(int goldLose) {
        this.gold -= goldLose;
    }
}
