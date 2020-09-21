package esi.atl.g53735.model;

/**
 *
 * @author g53735
 */
public class Player {

    private Deck deck;
    private int gold;
    private int score;

    public Player() {
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

    public void winGold(int goldWin) {
        this.gold = this.gold + goldWin;
    }

    public void loseGold(int goldLose) {
        this.gold = this.gold - goldLose;
    }

    public void startDeckPlayer(Deck gameDeck, Card card) {
        this.deck.getList().add(gameDeck.getList().get(0));
        gameDeck.getList().remove(gameDeck.getList().get(0));
        this.deck.getList().add(gameDeck.getList().get(0));
        gameDeck.getList().remove(0);
    }

    public void keepGoing(Boolean yesOrNo, Deck gameDeck) {
        if (yesOrNo == true) {
            this.deck.getList().add(gameDeck.getList().get(0));
            gameDeck.hit();
        }
    }

    public int scoreOfDeck() {
        for (int i = 0; i < this.deck.size(); i++) {
            this.score = this.score + this.deck.getList().get(i)
                    .valueOfCard(this.deck.getList().get(i).getValue());
        }
        return this.score;
    }
}
