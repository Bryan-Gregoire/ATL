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

    public List getDeck() {
        return this.cards;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int scoreOfDeck() {
        for (int i = 0; i < this.cards.size(); i++) {
            this.score = this.score + this.cards.get(i)
                    .valueOfCard(this.cards.get(i).getValue());
        }
        return score;
    }
}
