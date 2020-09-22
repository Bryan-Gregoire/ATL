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
            if (game.getGold() == 0) {
                break;
            }

            if (newRound) {
                view.displayWallet(game.getGold());
                game.resetCards(game.getPlayer().getHand(), game.getGameDeck());
                game.resetCards(game.getBank().getHand(), game.getGameDeck());
                game.getGameDeck().shuffle();
                game.beginHandPlayer();
                bet = view.askBet();
                while (bet > game.getGold()) {
                    view.displayMessage("Not enough in the wallet");
                    bet = view.askBet();
                }
                view.displayPossibleGain(bet);
                newRound = false;
            }

            view.displayPlayerCards(game.getPlayer().getHand());
            view.displayScore(game.getPlayer().getScore());
            view.displayWallet(game.getGold());

            if (game.checkAbove21(game.getPlayer())) {
                view.displayMessage("you lose this round");
                view.displayWallet(game.getGold());
                boolean again
                        = view.askYesOrNo("Do you want to play again ? : ");
                if (again) {
                    newRound = true;
                } else {
                    break;
                }
            }

            if (!view.askTakeCard()) {
                while (game.getBank().getScore() < 17) {
                    game.playerDrawCard(game.getBank());
                }
                if (game.checkAbove21(game.getBank()) || game.getPlayer()
                        .getScore() > game.getPlayer().getScore()) {
                    view.displayMessage("You won the round");
                    game.winGold(bet);
                    view.displayWallet(game.getGold());
                    boolean again
                            = view.askYesOrNo("Do you want to play again ? : ");
                    if (again) {
                        newRound = true;
                    } else {
                        end = true;
                    }
                } else if (game.getPlayer().getScore()
                        <= game.getBank().getScore()) {
                    view.displayMessage("The bank won this round");
                    game.loseGold(bet);
                    view.displayWallet(game.getGold());
                    boolean again
                            = view.askYesOrNo("Do you want to play again ? : ");
                    if (again) {
                        newRound = true;
                    } else {
                        end = true;
                    }
                }
            } else {
                game.getPlayer().takeCard(game.getGameDeck());
            }
        }
    }
}
