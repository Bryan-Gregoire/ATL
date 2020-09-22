package esi.atl.g53735.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g53735
 */
public class Bank {

    private List<Card> cards;
    private int score;

    public Bank() {
        this.cards = new ArrayList<>();
        this.score = 0;
    }

    public List getCards() {
        return this.cards;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }
    
    public void resetScore() {
        this.score = 0;
    }
    
    public void takeCard(Deck gameDeck, int n) {
        for (int i = 0; i < n; i++) {
            Card takenCard = gameDeck.hit();
            this.cards.add(takenCard);
            this.score += takenCard.valueOfCard(takenCard.getValue());
        }
    }
    
}
