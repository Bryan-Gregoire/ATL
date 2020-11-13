package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;

/**
 * Interface that represents the methods that must be in the view.
 *
 * @author g53735
 */
public interface InterfaceView {

    /**
     * Display the given message.
     *
     * @param message the given message.
     */
    public void displayMessage(String message);

    /**
     * Display the given board.
     *
     * @param board the given board.
     */
    public void displayBoard(Board board);

    /**
     * Display the current score.
     *
     * @param score the current score.
     */
    public void displayCurrentScore(int score);

}
