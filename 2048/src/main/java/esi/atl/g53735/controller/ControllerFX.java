package esi.atl.g53735.controller;

import esi.atl.g53735.model.Direction;
import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.InterfaceViewFX;
import java.beans.PropertyChangeListener;
import java.util.Objects;
import javafx.scene.input.KeyEvent;

/**
 * The Controller represents the dynamics of the game and the update of the View
 * as you go along.
 *
 * @author g53735
 */
public class ControllerFX {

    private final Model model;
    private final InterfaceViewFX view;

    /**
     * Constructor of controllerFX.
     *
     * @param game represent the model.
     * @param ViewFX represent the view in javaFX.
     */
    public ControllerFX(Model game, InterfaceViewFX ViewFX) {
        Objects.requireNonNull(game, "Model is required");
        Objects.requireNonNull(ViewFX, "View is required");
        this.model = game;
        this.view = ViewFX;
    }

    /**
     * Start a game.
     *
     */
    public void startGame() {
        this.model.startGame();
    }

    /**
     * Move the values of the game board in the direction of the event.
     *
     * @param e the direction which move.
     */
    public void keyDirection(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                this.model.move(Direction.UP);
                break;
            case DOWN:
                this.model.move(Direction.DOWN);
                break;
            case RIGHT:
                this.model.move(Direction.RIGHT);
                break;
            case LEFT:
                this.model.move(Direction.LEFT);
                break;
            default:
        }
    }

    /**
     * Add the given listener to the model.
     *
     * @param listener the given listener.
     */
    public void addModelListener(PropertyChangeListener listener) {
        model.addPropertChangeListener(listener);
    }

    /**
     * Remove the given listener of the model.
     *
     * @param listener the given listener.
     */
    public void removeModelListener(PropertyChangeListener listener) {
        model.removePropertyChangeListener(listener);
    }
}
