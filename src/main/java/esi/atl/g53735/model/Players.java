/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author Utilisateur
 */
public abstract class Players {

    protected List<Card> hand;
    protected int score;

    protected Players(List<Card> hand, int score) {
        this.hand = hand;
        this.score = score;
    }

    public List<Card> getHand() {
        return hand;
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

    public void takeCard(Deck gameDeck) {
        Card takenCard = gameDeck.hit();
        this.hand.add(takenCard);
        this.score += takenCard.valueOfCard(takenCard.getValue());
    }
}
