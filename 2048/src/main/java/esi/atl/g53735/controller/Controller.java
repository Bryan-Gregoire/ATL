package esi.atl.g53735.controller;

import esi.atl.g53735.model.Direction;
import esi.atl.g53735.model.LevelStatus;
import esi.atl.g53735.view.InterfaceView;
import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.View;

/**
 * The Controller represents the dynamics of the game and the update of the View
 * as you go along.
 *
 * @author g53735
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;

    /**
     * Constructor of the controller.
     *
     * @param game represent the model.
     * @param InterfaceView represent the view.
     */
    public Controller(Model game, View InterfaceView) {
        this.game = game;
        this.view = InterfaceView;
    }

    /**
     * Start a game.
     *
     */
    public void startGame() {
        this.game.startStatus();
        view.displayCurrentScore(game.getScore());
        this.view.displayBoard(this.game.getBoard());
        while (game.getStatus() == LevelStatus.IN_PROGRESS) {
            Direction direction = this.view.askDirection();
            game.move(direction);
            view.displayCurrentScore(game.getScore());
            this.view.displayBoard(this.game.getBoard());
        }

        if (game.getStatus() == LevelStatus.WIN) {
            view.displayMessage("GAME OVER, YOU WON !");
        } else if (game.getStatus() == LevelStatus.FAIL) {
            view.displayMessage("GAME OVER, You lost !");
        }
    }
}
