
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

    public Deck getDeck() {
        return deck;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public int scoreOfDeck() {
        for (int i = 0; i < this.deck.size(); i++) {
            this.score = this.score + this.deck.getList().get(i)
                    .valueOfCard(this.deck.getList().get(i).getValue());
        }
        return score;
    }
}
