package esi.atl.g53735.controller;

import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.InterfaceView;
import esi.atl.g53735.view.View;

/**
 *
 * @author g53735
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    public Controller(Model game, View interfaceView) {
        this.game = game;
        this.view = interfaceView;
    }

    public void startGame() {
        boolean end = false;
        boolean newRound = true;
        while (!end) {
            int bet = 0;
            if (game.getGold() <= 0) {
                view.displayMessage("Game over, you are broke");
                break;
            }

            if (newRound) {
                bet = view.askBet();
                while (bet > game.getGold() || bet <= 0) {
                    view.displayMessage("Not enough in the wallet");
                    bet = view.askBet();
                }
                beginNewRound(bet);
                view.displayPossibleGain(bet);
                newRound = false;
            } else {
                view.displayWallet(game.getGold());
            }

            view.displayPlayerCards(game.getPlayer().getHand());
            view.displayScore(game.getPlayer().getScore());

            if (view.askTakeCard()) {
                game.getPlayer().takeCard(game.getGameDeck());
            } else {
                while (game.getBank().getScore() < 17) {
                    game.playerDrawCard(game.getBank());
                }
                view.displayBankCards(game.getBank().getHand());
                view.displayBankScore(game.getBank().getScore());
                if (game.checkAbove21(game.getBank()) || game.getPlayer()
                        .getScore() > game.getPlayer().getScore()) {
                    view.displayMessage("You won the round");
                    game.winGold(bet);
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
                    game.loseGold(bet);
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
                game.loseGold(bet);
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

    public void beginNewRound(int bet) {
        view.displayWallet(game.getGoldWithBet(bet));
        game.resetCards(game.getPlayer().getHand(), game.getGameDeck());
        game.resetCards(game.getBank().getHand(), game.getGameDeck());
        game.getGameDeck().shuffle();
        game.resetScore();
        game.beginHandPlayer();
    }
}
