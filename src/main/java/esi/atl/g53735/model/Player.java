package esi.atl.g53735.model;

import esi.atl.g53735.cards.Card;
import esi.atl.g53735.cards.Deck;

/**
 *
 * @author g53735
 */
public class Player implements Model {

    private Deck deck;
    private int gold;
    private int score;

    public Player() {
        this.deck = new Deck();
        this.gold = 1000;
        this.score = 0;
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
    
    

    public void startPlayer(Deck gameDeck, Card card) {
        this.deck.getList().add(card);
        gameDeck.getList().remove(card);
        this.deck.getList().add(gameDeck.getList().get(0));
        gameDeck.getList().remove(0);
    }

    @Override
    public Deck getDeck() {
        return deck;
    }

    @Override
    public void keepGoing(Boolean yesOrNo, Deck gameDeck) {
        if (yesOrNo == true) {
            this.deck.getList().add(gameDeck.getList().get(0));
            gameDeck.getList().remove(0);
        }
    }
}
