package esi.atl.g53735.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g53735
 */
public class Player {

    private List<Card> hand;
    private int gold;
    private int score;

    public Player() {
        this.hand = new ArrayList<>();
        this.gold = 1000;
        this.score = 0;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getGold() {
        return gold;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int add) {
        this.score += add;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void winGold(int goldWin) {
        this.gold = this.gold + goldWin;
    }

    public void loseGold(int goldLose) {
        this.gold = this.gold - goldLose;
    }

    public void takeCard(Deck gameDeck) {
            Card takenCard = gameDeck.hit();
            this.hand.add(takenCard);
            this.score += takenCard.valueOfCard(takenCard.getValue());
    }
}
