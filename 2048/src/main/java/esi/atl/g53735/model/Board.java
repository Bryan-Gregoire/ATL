package esi.atl.g53735.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Game board, made up values of squares.
 *
 * @author g53735
 */
public final class Board {

    private final int[][] squares;
    private final ArrayList<Integer> freePlaces;
    private final static Random rand = new Random();
    private final static int SIZE = 4;

    /**
     * Constructor of board.
     *
     */
    public Board() {
        this(new int[SIZE][SIZE]);
        setRandomValueBoard();
    }

    /**
     * Constructor of board for the test.
     *
     * @param squares the squares.
     */
    Board(int[][] squares) {
        if (squares == null) {
            throw new IllegalArgumentException("Squares cannot be null");
        }
        this.squares = squares;
        this.freePlaces = new ArrayList<>();
        addFreePlaces();
    }

    /**
     * Get board of Squares.
     *
     * @return square.
     */
    public int[][] getSquares() {
        return copySquares();
    }

    /**
     * get the value of a given position in the squares.
     *
     * @param lg the line which the value is.
     * @param col the column which the value is.
     *
     * @return the value of the square.
     */
    public int getValue(int lg, int col) {
        if (lg < 0 || col < 0 || lg >= SIZE || col >= SIZE) {
            throw new IllegalArgumentException("lg or col are invalide values");
        }
        return this.squares[lg][col];
    }

    /**
     * Gives the number of rows on the game squares.
     *
     * @return the number of rows.
     */
    public int getNbRow() {
        return this.squares.length;
    }

    /**
     * Gives the number of columns on the game squares.
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
    public void setValue(int lg, int col, int value) {
        if (lg < 0 || col < 0 || lg >= SIZE || col >= SIZE || value > 0
                || value % 2 != 0) {
            throw new IllegalArgumentException("invalide value");
        }
        this.squares[lg][col] = value;
    }

    /**
     * Make a copy of the current squares.
     *
     * @return the copy.
     */
    private int[][] copySquares() {
        int[][] copy = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                copy[i][j] = this.squares[i][j];
            }
        }
        return copy;
    }

    /**
     * Check if squares changed after move.
     *
     * @param oldSquares the squares before the move.
     * @param newSquares the squares after the move.
     * @return true if changed, otherwise false.
     */
    private boolean boardChanged(int[][] oldSquares, int[][] newSquares) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (oldSquares[i][j] != newSquares[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if a value in the squares is 2048.
     *
     * @return true if a value is 2048, otherwise false.
     */
    public boolean winEnd() {
        for (int lg = 0; lg < SIZE; lg++) {
            for (int col = 0; col < SIZE; col++) {
                if (this.squares[lg][col] == 2048) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Check if it is possible to move.
     *
     * @return true if it is no possible to move otherwise false.
     */
    public boolean loseEnd() {
        if (this.freePlaces.isEmpty()) {
            return !hasSameNeighbour();
        }
        return false;
    }

    /**
     * check if the neighbor on the right or on the bottom has the same value as
     * the one chosen in the board. Ignore the last column and the last row.
     *
     * @return true if a value has a neigbor of the same value otherwise false.
     */
    private boolean hasSameNeighbour() {
        for (int lg = 0; lg < SIZE; lg++) {
            for (int col = 0; col < SIZE; col++) {
                if (col < SIZE - 1) {
                    if (this.squares[lg][col] == this.squares[lg][col + 1]) {
                        return true;
                    }
                }
                if (lg < SIZE - 1) {
                    if (this.squares[lg][col] == this.squares[lg + 1][col]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Randomly have 2 or 4. more chance of having a 2.
     *
     * @return 2 or 4.
     */
    public int randomValue() {
        int random = rand.nextInt(10);
        return random < 9 ? 2 : 4;
    }

    /**
     * Empty the list, add to the list the position of the free places on the
     * squares.
     *
     */
    public void addFreePlaces() {
        freePlaces.clear();
        int place = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.squares[i][j] == 0) {
                    this.freePlaces.add(place);
                }
                place++;
            }
        }
    }

    /**
     * If there is a free place in the squares, a value 2 or 4 randomly chosen
     * is placed randomly on the squares.
     *
     */
    public void setRandomValueBoard() {
        if (!freePlaces.isEmpty()) {
            if (freePlaces.size() == 1) {
                setValue(freePlaces.get(0) / SIZE,
                        freePlaces.get(0) % SIZE, randomValue());
            }
            int insertFreePlace = rand.nextInt(freePlaces.size());
            int lg = freePlaces.get(insertFreePlace) / SIZE;
            int col = freePlaces.get(insertFreePlace) % SIZE;
            this.squares[lg][col] = randomValue();
            this.freePlaces.remove(insertFreePlace);
        }
    }

    /**
     * Move the values of the squares in the given direction. if the squares
     * does not move return -2.
     *
     * @param direction the given direction.
     * @return -2 if squares has not changed,otherwise the value of the sum of
     * the values.
     */
    public int moveValues(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("this isn't a direction");
        }
        int[][] oldSquares = copySquares();
        int score = 0;
        switch (direction) {
            case UP:
                score = moveUp();
                break;
            case DOWN:
                score = moveDown();
                break;
            case LEFT:
                score = moveleft();
                break;
            case RIGHT:
                score = moveRight();
        }
        if (!boardChanged(oldSquares, this.squares)) {
            return -2;
        }
        return score;

    }

    /**
     * Add the same values and move them up.
     *
     * @return the value of the sum of the values.
     */
    private int moveUp() {
        int addToScore = 0;
        for (int col = 0; col < SIZE; col++) {
            addToScore += sumUp(col);
            moveAllUp(col);
        }
        return addToScore;
    }

    /**
     * Add the values of the board in the direction given. we add the values
     * which are the same. We do not sum the values 0, if between 2 numbers
     * which are the same there is a different number than these then there is
     * no sum to do.
     *
     * @param col the column of the squares.
     * @return the value of the sum.
     */
    private int sumUp(int col) {
        int addToScore = 0;
        for (int lg = 0; lg < SIZE - 1; lg++) {
            boolean out = false;
            int nextLg = lg + 1;
            if (this.squares[lg][col] != 0) {
                while (!out && nextLg < SIZE) {
                    if (this.squares[nextLg][col] > 0
                            && this.squares[lg][col]
                            != this.squares[nextLg][col]) {
                        out = true;
                    } else if (this.squares[lg][col]
                            == this.squares[nextLg][col]) {
                        this.squares[lg][col] *= 2;
                        this.squares[nextLg][col] = 0;
                        addToScore += this.squares[lg][col];
                        lg++;
                        out = true;
                    }
                    nextLg++;
                }
            }
        }
        return addToScore;
    }

    /**
     * Move all the values on the squares to the top, the values do not overlap.
     *
     * @param col the column of the squares.
     */
    private void moveAllUp(int col) {
        for (int lg = 0; lg < SIZE - 1; lg++) {
            boolean out = false;
            int lgMove = lg + 1;
            if (this.squares[lg][col] == 0) {
                while (!out && lgMove < SIZE) {
                    if (this.squares[lgMove][col] != 0) {
                        this.squares[lg][col] = this.squares[lgMove][col];
                        this.squares[lgMove][col] = 0;
                        out = true;
                    }
                    lgMove++;
                }
            }
        }
    }

    /**
     * Add the same values and move them down.
     *
     * @return the value of the sum of the values.
     */
    private int moveDown() {
        int addToScore = 0;
        for (int col = 0; col < SIZE; col++) {
            addToScore += sumDown(col);
            moveAllDown(col);
        }
        return addToScore;
    }

    /**
     * Add the values of the board in the direction given. we add the values
     * which are the same. We do not sum the values 0, if between 2 numbers
     * which are the same there is a different number than these then there is
     * no sum to do.
     *
     * @param col the column of the squares.
     * @return the value of the sum.
     */
    private int sumDown(int col) {
        int addToScore = 0;
        for (int lg = SIZE - 1; lg >= 1; lg--) {
            boolean out = false;
            int nextLg = lg - 1;
            if (this.squares[lg][col] != 0) {
                while (!out && nextLg >= 0) {
                    if (this.squares[nextLg][col] > 0
                            && this.squares[lg][col]
                            != this.squares[nextLg][col]) {
                        out = true;
                    } else if (this.squares[lg][col]
                            == this.squares[nextLg][col]) {
                        this.squares[lg][col] *= 2;
                        this.squares[nextLg][col] = 0;
                        addToScore += this.squares[lg][col];
                        lg--;
                        out = true;
                    }
                    nextLg--;
                }
            }
        }
        return addToScore;
    }

    /**
     * Move all the values on the squares to the bottom, the values do not
     * overlap.
     *
     * @param col the column of the squares.
     */
    private void moveAllDown(int col) {
        for (int lg = SIZE - 1; lg >= 1; lg--) {
            boolean out = false;
            int lgMove = lg - 1;
            if (this.squares[lg][col] == 0) {
                while (!out && lgMove >= 0) {
                    if (this.squares[lgMove][col] != 0) {
                        this.squares[lg][col] = this.squares[lgMove][col];
                        this.squares[lgMove][col] = 0;
                        out = true;
                    }
                    lgMove--;
                }
            }
        }
    }

    /**
     * Add the same values and move them left.
     *
     * @return the value of the sum of the values.
     */
    private int moveleft() {
        int addToScore = 0;
        for (int lg = 0; lg < SIZE; lg++) {
            addToScore += sumLeft(lg);
            moveAllLeft(lg);
        }
        return addToScore;
    }

    /**
     * Add the values of the board in the direction given. we add the values
     * which are the same. We do not sum the values 0, if between 2 numbers
     * which are the same there is a different number than these then there is
     * no sum to do.
     *
     * @param lg the line of the squares.
     * @return the value of the sum.
     */
    private int sumLeft(int lg) {
        int addToScore = 0;
        for (int col = 0; col < SIZE - 1; col++) {
            boolean out = false;
            int nextCol = col + 1;
            if (this.squares[lg][col] != 0) {
                while (!out && nextCol < SIZE) {
                    if (this.squares[lg][nextCol] > 0
                            && this.squares[lg][col]
                            != this.squares[lg][nextCol]) {
                        out = true;
                    } else if (this.squares[lg][col]
                            == this.squares[lg][nextCol]) {
                        this.squares[lg][col] *= 2;
                        this.squares[lg][nextCol] = 0;
                        addToScore += this.squares[lg][col];
                        col++;
                        out = true;
                    }
                    nextCol++;
                }
            }
        }
        return addToScore;
    }

    /**
     * Move all the values on the squares to the left, the values do not
     * overlap.
     *
     * @param lg the line of the squares.
     */
    private void moveAllLeft(int lg) {
        for (int col = 0; col < SIZE - 1; col++) {
            boolean out = false;
            int nextCol = col + 1;
            if (this.squares[lg][col] == 0) {
                while (!out && nextCol < SIZE) {
                    if (this.squares[lg][nextCol] != 0) {
                        this.squares[lg][col] = this.squares[lg][nextCol];
                        this.squares[lg][nextCol] = 0;
                        out = true;
                    }
                    nextCol++;
                }
                if (nextCol >= SIZE) { // Si plus de nombres a déplacer. 
                    col = SIZE;      // Aller a la fin pour sortir du for.
                }
            }
        }
    }

    /**
     * Add the same values and move them right.
     *
     * @return the value of the sum of the values.
     */
    private int moveRight() {
        int addToScore = 0;
        for (int lg = 0; lg < SIZE; lg++) {
            addToScore += sumRight(lg);
            moveAllRight(lg);
        }
        return addToScore;
    }

    /**
     * Add the values of the board in the direction given. we add the values
     * which are the same. We do not sum the values 0, if between 2 numbers
     * which are the same there is a different number than these then there is
     * no sum to do.
     *
     * @param lg the line of he game squares.
     * @return the value of the sum.
     */
    private int sumRight(int lg) {
        int addToScore = 0;
        for (int col = SIZE - 1; col > 0; col--) {
            boolean out = false;
            int beforeCol = col - 1;
            if (this.squares[lg][col] != 0) {
                while (!out && beforeCol >= 0) {
                    if (this.squares[lg][beforeCol] > 0
                            && this.squares[lg][col]
                            != this.squares[lg][beforeCol]) {
                        out = true;
                    } else if (this.squares[lg][col]
                            == this.squares[lg][beforeCol]) {
                        this.squares[lg][col] *= 2;
                        this.squares[lg][beforeCol] = 0;
                        addToScore += this.squares[lg][col];
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
        return addToScore;
    }

    /**
     * Move all the values on the squares to the right, the values do not
     * overlap.
     *
     * @param lg the line of the game squares.
     */
    private void moveAllRight(int lg) {
        for (int col = SIZE - 1; col > 0; col--) {
            boolean out = false;
            int beforeCol = col - 1;
            if (this.squares[lg][col] == 0) {
                while (!out && beforeCol >= 0) {
                    if (this.squares[lg][beforeCol] != 0) {
                        this.squares[lg][col] = this.squares[lg][beforeCol];
                        this.squares[lg][beforeCol] = 0;
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
