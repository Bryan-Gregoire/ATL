package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author g53735
 */
public class Player extends Players {

    private int gold;

    public Player(int gold, List<Card> hand, int score) {
        super(hand, score);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void winGold(int goldWin) {
        this.gold = this.gold + goldWin;
    }

    public void loseGold(int goldLose) {
        this.gold = this.gold - goldLose;
    }
    
}
