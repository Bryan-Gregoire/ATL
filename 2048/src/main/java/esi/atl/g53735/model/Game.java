package esi.atl.g53735.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Bring together the elements necessary for the game to present a facade to the
 * view.
 *
 * @author g53735
 */
public class Game implements Model {

    private Board board;
    private LevelStatus status;
    private int score;

    public static final String BOARD_MOVE = "Move";
    public static final String SCORE = "Add Score";
    public static final String STATUS = "Status";
    private PropertyChangeSupport pcs;

    /**
     * Constructor of Game.
     *
     */
    public Game() {
        this(new Board());
    }

    /**
     * Constructor of Game for the test.
     *
     * @param board the game board.
     */
    Game(Board board) {
        if (board == null) {
            throw new IllegalArgumentException("board cannot be null");
        }
        this.board = board;
        status = LevelStatus.NOT_STARTED;
        pcs = new PropertyChangeSupport(this);
    }

    /**
     * Start a game. Clean the game board, reset the score.
     */
    @Override
    public void startGame() {
        startStatus();
        this.board = new Board();
        this.pcs.firePropertyChange(BOARD_MOVE, null, this.board);
        this.score = 0;
        this.pcs.firePropertyChange(SCORE, -1, this.score);
    }

    /**
     * Get the board of the game.
     *
     * @return the board.
     */
    @Override
    public Board getBoard() {
        return new Board(board.getSquares());
    }

    /**
     * Get the score.
     *
     * @return the score.
     */
    @Override
    public int getScore() {
        return this.score;
    }

    /**
     * Get the state of the game.
     *
     * @return the state.
     */
    @Override
    public LevelStatus getStatus() {
        return status;
    }

    /**
     * Indicate that the game started.
     */
    @Override
    public void startStatus() {
        this.pcs.firePropertyChange(STATUS, this.status,
                LevelStatus.IN_PROGRESS);
        this.status = LevelStatus.IN_PROGRESS;
    }

    /**
     * Check and set the new status of the game.
     *
     */
    @Override
    public void updateLevelStatus() {
        if (this.board.winEnd()) {
            this.pcs.firePropertyChange(STATUS, this.status,
                    LevelStatus.WIN);
            this.status = LevelStatus.WIN;
        } else if (this.board.loseEnd()) {
            this.pcs.firePropertyChange(STATUS, this.status,
                    LevelStatus.FAIL);
            this.status = LevelStatus.FAIL;
        }
    }

    /**
     * Move the values of the game board in the given direction.
     *
     * @param direction the direction which move.
     */
    @Override
    public void move(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("This is not a direction");
        }
        if (this.status == LevelStatus.IN_PROGRESS) {
            int addScore = board.moveValues(direction);
            if (addScore != -2) {
                addToScore(addScore);
                board.addFreePlaces();
                board.setRandomValueBoard();
                updateLevelStatus();
                pcs.firePropertyChange(BOARD_MOVE, null, board);
            } else {
                pcs.firePropertyChange(SCORE, -2, this.score);
            }
        }
    }

    /**
     * Add the given integer to the game score.
     *
     * @param addToScore the given integer.
     */
    private void addToScore(int addToScore) {
        if (addToScore < 0) {
            throw new IllegalArgumentException("the score to add cannot be "
                    + "negative");
        }
        int oldValue = this.score;
        this.score += addToScore;
        pcs.firePropertyChange(SCORE, oldValue, score);
    }

    /**
     * Add listener
     *
     * @param listener the listener.
     */
    @Override
    public void addPropertChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    /**
     * Remove listener.
     *
     * @param listener the listener.
     */
    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}
