
package esi.atl.g53735.model;

/**
 *
 * @author g53735
 */
public class Bank {
    
    private Deck deck;
    private int score;

    public Bank() {
        this.deck = new Deck();
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
