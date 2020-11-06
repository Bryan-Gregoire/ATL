package esi.atl.g53735.model;

import java.util.ArrayList;

/**
 * Game board, made up of board.
 *
 * @author g53735
 */
public final class Board {

    private final int[][] board;
    private final ArrayList<Integer> freePlaces = new ArrayList<>();

    /**
     * Constructor of the game board.
     *
     */
    public Board() {
        this.board = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
        };
        addFreePlaces();
        setRandomValueBoard();
    }

    /**
     * Get a Square.
     *
     * @return square.
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * get the value of a given position in the board.
     *
     * @param lg the line which the value is.
     * @param col the column which the value is.
     *
     * @return the value of the square.
     */
    public int getValue(int lg, int col) {
        return this.board[lg][col];
    }

    /**
     * Gives the number of rows on the game board.
     *
     * @return the number of rows.
     */
    public int getNbRow() {
        return this.board.length;
    }

    /**
     * Gives the number of columns on the game board.
     *
     * @return the number of columns.
     */
    public int getNbColumn() {
        return this.board[0].length;
    }

    /**
     * Set a value in a square at a given position.
     *
     * @param lg the line which the square is.
     * @param col the column which the square is.
     * @param value the given value to set.
     */
    public void setValue(int lg, int col, int value) {
        this.board[lg][col] = value;
    }

    public int randomValue() {
        int rand = (int) (Math.random() * 10);
        return rand < 9 ? 2 : 4;
    }

    public void addFreePlaces() {
        freePlaces.clear();
        int place = 0;
        for (int i = 0; i < getNbRow(); i++) {
            for (int j = 0; j < getNbColumn(); j++) {
                if (getValue(i, j) == 0) {
                    this.freePlaces.add(place);
                }
                place++;
            }
        }
    }

    public void setRandomValueBoard() {
        if (!freePlaces.isEmpty()) {
            if (freePlaces.size() == 1) {
                setValue(freePlaces.get(0) / getNbRow(),
                        freePlaces.get(0) % getNbColumn(), randomValue());
            }
            int insertFreePlace = (int) (Math.random() * freePlaces.size());
            int lg = freePlaces.get(insertFreePlace) / getNbRow();
            int col = freePlaces.get(insertFreePlace) % getNbColumn();
            setValue(lg, col, randomValue());
        }
    }

    public int doubleValues(int lg, int col) {
        return getValue(lg, col) * 2;
    }

    public void moveValues(Direction direction) {
        switch (direction) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveleft();
                break;
            case RIGHT:
                moveRight();
                break;
        }
    }

    private void moveUp() {
        for (int col = 0; col < getNbColumn(); col++) {
            sumUp(col);
            moveAllUp(col);
        }
    }

    private void sumUp(int col) {
        int nbRow = getNbRow();
        for (int lg = 0; lg < nbRow - 1; lg++) {
            boolean out = false;
            int nextLg = lg + 1;
            if (getValue(lg, col) != 0) {
                while (!out && nextLg < nbRow) {
                    if (getValue(nextLg, col) > 0 && getValue(lg, col)
                            != getValue(nextLg, col)) {
                        out = true;
                    } else if (getValue(lg, col)
                            == getValue(nextLg, col)) {
                        setValue(lg, col, doubleValues(lg, col));
                        setValue(nextLg, col, 0);
                        lg++;
                        out = true;
                    }
                    nextLg++;
                }
            }
        }
    }

    private void moveAllUp(int col) {
        int nbRow = getNbRow();
        for (int lg = 0; lg < nbRow - 1; lg++) {
            boolean out = false;
            int lgMove = lg + 1;
            if (getValue(lg, col) == 0) {
                while (!out && lgMove < nbRow) {
                    if (getValue(lgMove, col) != 0) {
                        setValue(lg, col, getValue(lgMove, col));
                        setValue(lgMove, col, 0);
                        out = true;
                    }
                    lgMove++;
                }
            }
        }
    }

    private void moveDown() {
        for (int col = 0; col < getNbColumn(); col++) {
            sumDown(col);
            moveAllDown(col);
        }
    }

    private void sumDown(int col) {
        int nbRow = getNbRow();
        for (int lg = nbRow - 1; lg >= 1; lg--) {
            boolean out = false;
            int nextLg = lg - 1;
            if (getValue(lg, col) != 0) {
                while (!out && nextLg >= 0) {
                    if (getValue(nextLg, col) > 0 && getValue(lg, col)
                            != getValue(nextLg, col)) {
                        out = true;
                    } else if (getValue(lg, col)
                            == getValue(nextLg, col)) {
                        setValue(lg, col, doubleValues(lg, col));
                        setValue(nextLg, col, 0);
                        lg--;
                        out = true;
                    }
                    nextLg--;
                }
            }
        }
    }

    private void moveAllDown(int col) {
        int nbRow = getNbRow();
        for (int lg = nbRow - 1; lg >= 1; lg--) {
            boolean out = false;
            int lgMove = lg - 1;
            if (getValue(lg, col) == 0) {
                while (!out && lgMove >= 0) {
                    if (getValue(lgMove, col) != 0) {
                        setValue(lg, col, getValue(lgMove, col));
                        setValue(lgMove, col, 0);
                        out = true;
                    }
                    lgMove--;
                }
            }
        }
    }

    private void moveleft() {
        for (int lg = 0; lg < getNbRow(); lg++) {
            sumLeft(lg);
            moveAllLeft(lg);
        }
    }

    private void sumLeft(int lg) {
        for (int col = 0; col < getNbColumn() - 1; col++) {
            boolean out = false;
            int nextCol = col + 1;
            if (getValue(lg, col) != 0) {
                while (!out && nextCol < getNbColumn()) {
                    if (getValue(lg, nextCol) > 0 && getValue(lg, col)
                            != getValue(lg, nextCol)) {
                        out = true;
                    } else if (getValue(lg, col) == getValue(lg, nextCol)) {
                        setValue(lg, col, doubleValues(lg, col));
                        setValue(lg, nextCol, 0);
                        col++;
                        out = true;
                    }
                    nextCol++;
                }
            }
        }
    }

    private void moveAllLeft(int lg) {
        int nbCol = getNbColumn();
        for (int col = 0; col < nbCol - 1; col++) {
            boolean out = false;
            int nextCol = col + 1;
            if (getValue(lg, col) == 0) {
                while (!out && nextCol < nbCol) {
                    if (getValue(lg, nextCol) != 0) {
                        setValue(lg, col, getValue(lg, nextCol));
                        setValue(lg, nextCol, 0);
                        out = true;
                    }
                    nextCol++;
                }
                if (nextCol >= nbCol) { // Si plus de nombres a déplacer. 
                    col = nbCol;      // Aller a la fin pour sortir du for.
                }
            }
        }
    }

    private void moveRight() {
        for (int lg = 0; lg < getNbRow(); lg++) {
            sumRight(lg);
            moveAllRight(lg);
        }
    }

    private void sumRight(int lg) {
        for (int col = getNbColumn() - 1; col > 0; col--) {
            boolean out = false;
            int beforeCol = col - 1;
            if (getValue(lg, col) != 0) {
                while (!out && beforeCol >= 0) {
                    if (getValue(lg, beforeCol) > 0 && getValue(lg, col)
                            != getValue(lg, beforeCol)) {
                        out = true;
                    } else if (getValue(lg, col) == getValue(lg, beforeCol)) {
                        setValue(lg, col, doubleValues(lg, col));
                        setValue(lg, beforeCol, 0);
                        col--;
                        out = true;
                    }
                    beforeCol--;
                }
                if (beforeCol < 0) { // Plus de nombres a Additionner
                    col = 0;    // Aller au début de mes col pour sortir du for.
                }
            }
        }
    }

    private void moveAllRight(int lg) {
        int nbCol = getNbColumn();
        for (int col = nbCol - 1; col > 0; col--) {
            boolean out = false;
            int beforeCol = col - 1;
            if (getValue(lg, col) == 0) {
                while (!out && beforeCol >= 0) {
                    if (getValue(lg, beforeCol) != 0) {
                        setValue(lg, col, getValue(lg, beforeCol));
                        setValue(lg, beforeCol, 0);
                        out = true;
                    }
                    beforeCol--;
                }
                if (beforeCol < 0) { // Si plus de nombres a déplacer. 
                    col = 0;      // Aller a la fin pour sortir du for.
                }
            }
        }
    }
}
