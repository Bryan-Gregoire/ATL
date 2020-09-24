package esi.atl.g53735.controller;

import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.InterfaceView;
import esi.atl.g53735.view.View;

/**
 * Represent the controller.
 *
 * @author g53735
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * The constructor of Controller.
     *
     * @param game the game.
     * @param interfaceView the interface of view.
     */
    public Controller(Model game, View interfaceView) {
        this.game = game;
        this.view = interfaceView;
    }

    /**
     * Start the game.
     *
     */
    public void startGame() {
        boolean end = false;
        boolean newRound = true;
        while (!end) {
            if (game.getGold() <= 0) {
                view.displayMessage("GAME OVER, you are broke");
                break;
            }

            if (newRound) {
                game.setBet(view.askBet());
                while (game.getBet() > game.getGold() || game.getBet() <= 0) {
                    view.displayMessage("The bet is not correct");
                    game.setBet(view.askBet());
                }
                beginNewRound(game.getBet());
                view.displayPossibleGain(game.getBet());
                newRound = false;
            } else {
                view.displayWalletMinusBet(game.getGold(), game.getBet());
            }

            view.displayPlayerCards(game.getPlayer().getHand());
            view.displayScore(game.getPlayer().getScore());

            if (view.askTakeCard()) {
                game.playerDrawCard(game.getPlayer());
            } else {
                while (game.getBank().getScore() < 17) {
                    game.playerDrawCard(game.getBank());
                }
                view.displayBankCards(game.getBank().getHand());
                view.displayBankScore(game.getBank().getScore());
                if (game.checkAbove21(game.getBank()) || game.getPlayer()
                        .getScore() > game.getBank().getScore()) {
                    view.displayMessage("You won the round");
                    game.winGold();
                    view.displayWallet(game.getGold());
                    if (view.askYesOrNo("Do you want to play again ?"
                            + "(y/yes or n/no) : ")) {
                        newRound = true;
                    } else {
                        break;
                    }
                } else if (game.getPlayer().getScore()
                        <= game.getBank().getScore()) {
                    view.displayMessage("The bank won this round");
                    game.loseGold();
                    view.displayWallet(game.getGold());
                    if (view.askYesOrNo("Do you want to play again ?"
                            + "(y/yes or n/no) : ")) {
                        newRound = true;
                    } else {
                        break;
                    }
                }
            }
            if (game.checkAbove21(game.getPlayer())) {
                view.displayMessage("you lost this round");
                game.loseGold();
                view.displayWallet(game.getGold());
                if (view.askYesOrNo("Do you want to play again ?"
                        + "(y/yes or n/no) : ")) {
                    newRound = true;
                } else {
                    end = true;
                }
            }
        }
        view.displayMessage("Thanks for playing");
    }

    /**
     * Display the money of the player,put all the cards back in the game deck,
     * shuffle the deck, reset the scores and give 2 cards to the player.
     *
     * @param bet the given bet.
     */
    public void beginNewRound(int bet) {
        view.displayWalletMinusBet(game.getGold(), bet);
        game.resetCards(game.getPlayer().getHand(), game.getGameDeck());
        game.resetCards(game.getBank().getHand(), game.getGameDeck());
        game.getGameDeck().shuffle();
        game.resetScore();
        game.beginHandPlayer();
    }
}
