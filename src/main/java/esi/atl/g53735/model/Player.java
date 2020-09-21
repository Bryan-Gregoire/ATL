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

    public void winGold(int goldWin) {
        this.gold = this.gold + goldWin;
    }

    public void loseGold(int goldLose) {
        this.gold = this.gold - goldLose;
    }

    public void startHandsPlayer(Deck gameDeck) {
        for (int i = 0; i < 2; i++) {
            this.hand.add(gameDeck.getList().get(0));
            this.score += this.hand.get(i)
                    .valueOfCard(this.hand.get(i).getValue());
            gameDeck.hit();
        }
    }

    public void keepGoing(boolean yesOrNo, Deck gameDeck) {
        if (yesOrNo) {
            this.hand.add(gameDeck.getList().get(0));
            this.score += this.hand.get(this.hand.size() - 1)
                    .valueOfCard(this.hand.get(this.hand.size() - 1)
                            .getValue());
            gameDeck.hit();
        }
    }

//    public static void main(String[] args) {
//        Deck deck54 = new Deck();
//        deck54.shuffle();
//        Player player = new Player();
//        player.startDeckPlayer(deck54);
//        System.out.println(player.getHand().toString());
//        System.out.println(player.score);
//    }
}
