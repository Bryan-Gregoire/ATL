package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;
import esi.atl.g53735.model.Direction;
import java.util.Scanner;

/**
 * Represents the View of the game.
 *
 * @author g53735
 */
public class View implements InterfaceView {

    private final Scanner keyboard;

    /**
     * Constructor of my Scanner.
     *
     */
    public View() {
        this.keyboard = new Scanner(System.in);
    }

    /**
     * Display the given message.
     *
     * @param message the message to display.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Display the current score.
     *
     * @param score the score.
     */
    @Override
    public void displayCurrentScore(int score) {
        System.out.println("Score : " + score);
    }

    /**
     * Displat the game board.
     *
     * @param board the board to display.
     */
    @Override
    public void displayBoard(Board board) {
        int lineCount = board.getNbRow();
        int colCount = board.getNbColumn();
        for (int line = 0; line < lineCount; line++) {
            for (int col = 0; col < colCount; col++) {
                int value = board.getValue(line, col);
                if (value < 10) {
                    System.out.print(" |   " + value);
                } else if (value < 100) {
                    System.out.print(" |  " + value);
                } else if (value < 1000) {
                    System.out.print(" | " + value);
                } else if (value < 10000) {
                    System.out.print(" |" + value);
                }
                if (col == 3) {
                    System.out.println(" |");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Ask to enter a direction.
     *
     * @return the given direction.
     */
    @Override
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
