package esi.atl.g53735.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * Game board, made up of squares.
 *
 * @author g53735
 */
public class Board {

    private final Square[][] squares;

    /**
     * Constructor of the game board.
     *
     */
    public Board() {
        this.squares = new Square[][]{
            {new Square(), new Square(), new Square(), new Square()},
            {new Square(), new Square(), new Square(), new Square()},
            {new Square(), new Square(), new Square(), new Square()},
            {new Square(), new Square(), new Square(), new Square()}
        };
    }

    /**
     * get the value of the square of a given position.
     *
     * @param lg the line which the square is.
     * @param col the column which the square is.
     *
     * @return the value of the square.
     */
    public int getSquareValue(int lg, int col) {
        return getSquare(lg, col).getValue();
    }

    /**
     * Get a square of a given position.
     *
     * @param lg the line which the square is.
     * @param col the column which the square is.
     *
     * @return the square.
     */
    public Square getSquare(int lg, int col) {
        return this.squares[lg][col];
    }

    /**
     * Get a Square.
     *
     * @return square.
     */
    public Square[][] getSquares() {
        return squares;
    }

    /**
     * Gives the number of rows on the game board.
     *
     * @return the number of rows.
     */
    public int getNbRow() {
        return this.squares.length;
    }

    /**
     * Gives the number of columns on the game board.
     *
     * @return the number of columns.
     */
    public int getNbColumn() {
        return this.squares[0].length;
    }

    /**
     * Set a value in a square at a given position.
     *
     * @param lg the line which the square is.
     * @param col the column which the square is.
     * @param value the given value to set.
     */
    public void setSquareValue(int lg, int col, int value) {
        this.squares[lg][col].setValue(value);
    }

    public int randomValue() {
        int rand = (int) (Math.random() * 10);
        return rand < 9 ? 2 : 4;
    }

    public boolean freePlace() {
        for (int i = 0; i < getNbRow(); i++) {
            for (int j = 0; j < getNbColumn(); j++) {
                if (getSquareValue(i, j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setRandomValueBoard() {
        int lg = (int) (Math.random() * 4);
        int col = (int) (Math.random() * 4);
        if (getSquare(lg, col).getValue() == 0) {
            setSquareValue(lg, col, randomValue());
        } else {
            boolean end = false;
            int last = 1;
            while (last <= getNbRow() * getNbColumn() && !end) {
                lg++;
                col++;
                if (lg >= getNbRow()) {
                    lg = 0;
                }
                if (col >= getNbColumn()) {
                    col = 0;
                }
                if (getSquareValue(lg, col) == 0) {
                    setSquareValue(lg, col, randomValue());
                    end = true;
                }
                last++;
            }
        }

    }

    public int doubleValues(int lg, int col) {
        return getSquareValue(lg, col) * 2;
    }

    public void moveValues(Direction direction) {
        switch (direction) {
            case UP:
                sumBeforeUp();
                moveUp();
                break;
            case DOWN:
                moveDownSum();
                break;
            case LEFT:
                moveLeft();
            case RIGHT:
                moveRight();
        }
    }

    private void sumBeforeUp() {
        int nbRow = getNbRow();
        int nbCol = getNbColumn();
        int lgSum = 1;
        boolean out = false;
        for (int lg = 0; lg < nbRow; lg++) {
            for (int col = 0; col < nbCol; col++) {
                if (getSquareValue(lg, col) != 0) {
                    while (!out && lgSum < nbRow) {
                        if (getSquareValue(lg, col)
                                == getSquareValue(lgSum, col)) {
                            setSquareValue(lg, col, doubleValues(lg, col));
                            setSquareValue(lgSum, col, 0);
                            out = true;
                        }
                        lgSum++;
                    }
                }
                lgSum = lg + 1;
                out = false;
            }
        }
    }

    private void moveUp() {
        boolean out = false;
        int nbRow = getNbRow();
        int nbCol = getNbColumn();
        int lgMove = 1;
        for (int lg = 0; lg < nbRow; lg++) {
            for (int col = 0; col < nbCol; col++) {
                if (getSquareValue(lg, col) == 0) {
                    while (!out && lgMove < nbRow) {
                        if (getSquareValue(lgMove, col) != 0) {
                            setSquareValue(lg, col, getSquareValue(lgMove, col));
                            setSquareValue(lgMove, col, 0);
                            out = true;
                        }
                        lgMove++;
                    }
                }
            }
            lgMove = lg + 1;
            out = false;
        }
    }

    private void moveDownSum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void moveLeft() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void moveRight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
