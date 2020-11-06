package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;
import esi.atl.g53735.model.Direction;

/**
 * Interface that represents the methods that must be in the view.
 *
 * @author g53735
 */
public interface InterfaceView {

    public void displayMessage(String message);

    public void displayBoard(Board board);

    public void displayCurrentScore(int score);

    public Direction askDirection();

}
