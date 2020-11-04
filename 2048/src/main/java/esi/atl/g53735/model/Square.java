package esi.atl.g53735.model;

/**
 * Square on the board. A square has a value. A square does not know where it is
 * on the board.
 *
 * @author g53735
 */
public class Square {

    private int value;

    /**
     * Constructor of Square on board.
     *
     */
    public Square() {
        this.value = 0;
    }

    /**
     * Simple getter of value.
     *
     * @return value of the square.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Set a integer.
     *
     * @param newValue the given integer.
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }
}
