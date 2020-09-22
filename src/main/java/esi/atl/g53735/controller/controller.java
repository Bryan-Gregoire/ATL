package esi.atl.g53735.controller;

import esi.atl.g53735.model.Model;
import esi.atl.g53735.model.Player;
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
            if (newRound) {
                game.resetCards(game.getPlayer().getHand(), game.getGameDeck());
                game.resetCards(game.getBank().getHand(), game.getGameDeck());
                game.getGameDeck().shuffle();
                game.beginHandPlayer();
                newRound = false;
            }
            
            view.displayPlayerCards(game.getPlayer().getHand());
            view.displayScore(game.getPlayer().getScore());
            
            if (game.checkScoreLose(game.getPlayer())) {
                view.displayMessage("Game over, you lose");
                boolean again = view.askYesOrNo("Do you want to play again ? : ");
                if (again) {
                    newRound = true;
                } else {
                    end = true;
                    break;
                }
            }
            int bet = view.askBet("How much do you want to bet ? :");
            view.displayPossibleGain(bet);

            if (!view.askTakeCard()) {
                while(game.getBank().getScore() < 17) {
                    game.getBank().takeCard(game.getGameDeck());
                }
              if(game.getBank().getScore() > 21) {
                  
              }
            } else {
                game.getPlayer().takeCard(game.getGameDeck());
            }
        }
    }
}
