
package esi.atl.g53735.model;

import esi.atl.g53735.cards.Deck;

/**
 *
 * @author g53735
 */
public class Bot {
    
    private Deck deck;
    private int gold;
    private int score;

    public Bot() {
        this.deck = new Deck();
        this.gold = 1000;
        this.score = 0;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getGold() {
        return gold;
    }

    public int getScore() {
        return score;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setScore(int score) {
        this.score = score;
    }
 
}
