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
                game.beginHandPlayer();
                newRound = false;
            }
            if (game.checkPlayerLose()) {
                view.displayMessage("Game over, you lose");
                boolean again = view.askYesOrNo("Voulez vous rejoué ? : ");
            }
            view.displayPlayerCards(game.getPlayer().getHand());

            if (!view.askTakeCard()) {

            } else {
                game.playerDrawCard();
            }
        }
    }
}
