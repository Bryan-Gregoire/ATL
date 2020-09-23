package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author g53735
 */
public class Player extends Players {

    private int gold;

    public Player(List<Card> hand) {
        super(hand, 0);
        this.gold = 1000;
    }

    public int getGold() {
        return gold;
    }
    
    public int getGoldWithBet(int bet){
        return this.gold -= bet;
    }

    public void winGold(int goldWin) {
        this.gold += goldWin;
    }

    public void loseGold(int goldLose) {
        this.gold -= goldLose;
    } 
}
