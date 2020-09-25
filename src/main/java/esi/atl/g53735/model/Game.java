package esi.atl.g53735.model;

import java.util.List;

/**
 *
 * @author g53735
 */
public class Game implements Model {

    private Player player;
    private Bank bank;
    private Deck gameDeck;
    private int bet;

    /**
     * Constructor of the Game.
     *
     * @param player player of the game.
     * @param bank the bank of the game.
     * @param gameDeck the game deck.
     */
    public Game(Player player, Bank bank, Deck gameDeck) {
        this.player = player;
        this.bank = bank;
        this.gameDeck = gameDeck;
        this.bet = 0;
    }

    /**
     * Get the game deck.
     *
     * @return the deck.
     */
    @Override
    public Deck getGameDeck() {
        return this.gameDeck;
    }

    /**
     * Get the player of the game.
     *
     * @return the player.
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * Get the bet.
     *
     * @return the bet.
     */
    @Override
    public int getBet() {
        return bet;
    }

    /**
     * Set a bet.
     *
     * @param bet the bet.
     */
    @Override
    public void setBet(int bet) {
        this.bet = bet;
    }

    /**
     * Reset the score of the player and the bank.
     *
     */
    @Override
    public void resetScore() {
        player.resetScore();
        bank.resetScore();
    }

    /**
     * Get the bank.
     *
     * @return the bank.
     */
    @Override
    public Bank getBank() {
        return this.bank;
    }

    /**
     * Get the money of the player.
     *
     * @return the money.
     */
    @Override
    public int getGold() {
        return this.player.getGold();
    }

    /**
     * Make the player draw 2 cards.
     */
    @Override
    public void beginHandPlayer() {
        player.takeCard(this.gameDeck);
        player.takeCard(this.gameDeck);
    }

    /**
     * Make the player draw a card.
     *
     * @param players the player who draws.
     */
    @Override
    public void playerDrawCard(Players players) {
        players.takeCard(this.gameDeck);
    }

    /**
     * Check if the score of the player is above 21.
     *
     * @param players the given player.
     * @return true if it is above 21 else false.
     */
    @Override
    public boolean checkAbove21(Players players) {
        return players.getScore() > 21;
    }

    /**
     * Return the player and bank cards to the game deck.
     *
     * @param hand the cards of the player.
     * @param gameDeck the deck of the game.
     */
    @Override
    public void resetCards(List<Card> hand, Deck gameDeck) {
        for (int i = hand.size() - 1; i >= 0; i--) {
            Card card = hand.remove(i);
            gameDeck.getList().add(card);
        }
    }

    /**
     * Add the winning bet to the player's money.
     *
     */
    @Override
    public void winGold() {
        this.player.winGold(this.bet);
    }

    /**
     * The player loses the money he has bet.
     */
    @Override
    public void loseGold() {
        this.player.loseGold(this.bet);
    }

    /**
     * Check if the player has money.
     *
     * @return true if the player has no money else false.
     */
    @Override
    public boolean checkBroke() {
        return player.getGold() <= 0;
    }

    /**
     * Check if the bet is correct.
     *
     * @return true if the bet is not correct else false.
     */
    @Override
    public boolean notCorrectBet() {
        return this.bet > getGold() || getBet() <= 0;
    }

    /**
     * Start of a round.
     *
     */
    @Override
    public void startOfRound() {
        resetCards(this.player.getHand(), this.gameDeck);
        resetCards(this.bank.getHand(), this.gameDeck);
        this.gameDeck.shuffle();
        resetScore();
        beginHandPlayer();
    }

    /**
     * Check if the scre of the bank is under 17.
     *
     * @return true if bank has a score under 17 else false.
     */
    @Override
    public boolean bankScoreUnder17() {
        return bank.getScore() < 17;
    }

    /**
     * Check if the player won the round.
     *
     * @return true if the player won else false.
     */
    @Override
    public boolean checkPlayerWin() {
        return checkAbove21(this.bank)
                || this.player.getScore() > this.bank.getScore();
    }
}
