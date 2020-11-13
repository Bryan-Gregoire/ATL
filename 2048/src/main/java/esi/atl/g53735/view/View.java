package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;

/**
 * Represents the View of the game.
 *
 * @author g53735
 */
public class View implements InterfaceView {

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
}
