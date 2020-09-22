package esi.atl.g53735.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author g53735
 */
public class Bank extends Players {

    public Bank(List<Card> hand, int score) {
        super(hand, score);
    }
    
    public void takeCard(Deck gameDeck, int n) {
        for (int i = 0; i < n; i++) {
            Card takenCard = gameDeck.hit();
            this.hand.add(takenCard);
            this.score += takenCard.valueOfCard(takenCard.getValue());
        }
    }
}
