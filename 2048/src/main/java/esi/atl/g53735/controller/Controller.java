package esi.atl.g53735.controller;

import esi.atl.g53735.model.Direction;
import esi.atl.g53735.model.LevelStatus;
import esi.atl.g53735.view.InterfaceView;
import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.View;
import java.util.Scanner;

/**
 * The Controller represents the dynamics of the game and the update of the View
 * as you go along.
 *
 * @author g53735
 */
public class Controller {

    private final Model game;
    private final InterfaceView view;
    private final Scanner keyboard = new Scanner(System.in);

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
            Direction direction = askDirection();
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

    /**
     * Ask to enter a direction.
     *
     * @return the given direction.
     */
    public Direction askDirection() {
        System.out.println("Which direction want to move(U/UP,D/DOWN,R/RIGHT"
                + ",L/LEFT) :");
        String dir = keyboard.nextLine().toUpperCase();
        while (!"U".equals(dir) && !"UP".equals(dir)
                && !"D".equals(dir) && !"DOWN".equals(dir)
                && !"R".equals(dir) && !"RIGHT".equals(dir)
                && !"L".equals(dir) && !"LEFT".equals(dir)) {
            System.out.println("This is not a direction");
            System.out.println("Enter a direction: ");
            dir = keyboard.nextLine().toUpperCase();
        }
        return senseDirection(dir);
    }

    /**
     * If a given string corresponds to a direction.
     *
     * @param direction the given string which represent the direction.
     * @return the direction.
     */
    private Direction senseDirection(String direction) {
        switch (direction) {
            case "U":
            case "UP":
                return Direction.UP;
            case "D":
            case "DOWN":
                return Direction.DOWN;
            case "L":
            case "LEFT":
                return Direction.LEFT;
        }
        return Direction.RIGHT;
    }
}
