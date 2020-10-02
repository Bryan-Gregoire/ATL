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
        view.displayMessage("Welcome to  Blackjack");
        view.displayWallet(game.getGold());
        while (!end) {
            if (game.checkBroke()) {
                view.displayMessage("GAME OVER, you are broke");
                end = true;
            } else {
                if (newRound) {
                    game.setBet(view.askBet());
                    while (game.notCorrectBet()) {
                        view.displayMessage("The bet is not correct");
                        game.setBet(view.askBet());
                    }
                    view.displayWalletMinusBet(game.getGold(), game.getBet());
                    game.startOfRound();
                    view.displayPossibleGain(game.getBet());
                    newRound = false;
                }

                view.displayPlayerCards(game.getPlayer().getHand());
                view.displayScore(game.getPlayer());

                if (view.askTakeCard()) {
                    game.playerDrawCard(game.getPlayer());
                    if (game.checkAbove21(game.getPlayer())) {
                        view.displayPlayerCards(game.getPlayer().getHand());
                        view.displayScore(game.getPlayer());
                        view.displayMessage("The bank won this round");
                        game.loseGold();
                        view.displayWallet(game.getGold());
                        if (view.askYesOrNo("Do you want to play again ?"
                                + "(y/yes or n/no) : ")) {
                            newRound = true;
                        } else {
                            end = true;
                        }
                    }
                } else {
                    //@pbt ça, ça doit être dans le modèle
                    while (game.bankScoreUnder17()) {
                        game.playerDrawCard(game.getBank());
                    }
                    view.displayBankCards(game.getBank().getHand());
                    view.displayScore(game.getBank());
                    if (game.checkPlayerWin()) {
                        view.displayMessage("You won the round");
                        game.winGold();
                        view.displayWallet(game.getGold());
                        if (view.askYesOrNo("Do you want to play again ?"
                                + "(y/yes or n/no) : ")) {
                            newRound = true;
                        } else {
                            end = true;
                        }
                    } else {
                        view.displayMessage("The bank won this round");
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
            }
        }
        view.displayMessage("Thanks for playing");
    }
}
