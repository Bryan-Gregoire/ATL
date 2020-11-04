package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;
import esi.atl.g53735.model.Direction;

/**
 *
 * @author g53735
 */
public interface InterfaceView {

    public void displayMessage(String message);

    public void displayBoard(Board board);

    public Direction askDirection();
}
