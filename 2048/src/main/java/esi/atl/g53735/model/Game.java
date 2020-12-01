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
    private LevelStatus status = LevelStatus.NOT_STARTED;
    int score = 0;

    public static final String BOARD_MOVE = "Move";
    public static final String SCORE = "Add Score";
    public static final String STATUS = "Status";
    private PropertyChangeSupport pcs;

    /**
     * Constructor of Game.
     *
     */
    public Game() {
        pcs = new PropertyChangeSupport(this);
    }

    /**
     * Constructor of Game for the test.
     *
     * @param board the game board.
     */
    Game(Board board) {
        this.board = board;
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
        this.pcs.firePropertyChange(SCORE, this.score, 0);
        this.score = 0;
    }

    /**
     * Get the board of the game.
     *
     * @return the board.
     */
    @Override
    public Board getBoard() {
        return board;
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
        this.status = LevelStatus.IN_PROGRESS;
        this.pcs.firePropertyChange(STATUS, LevelStatus.NOT_STARTED,
                this.status);
    }

    /**
     * Check and set the new status of the game.
     *
     */
    @Override
    public void setNewLevelStatus() {
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
        addToScore(board.moveValues(direction));
        board.addFreePlaces();
        board.setRandomValueBoard();
        setNewLevelStatus();
        pcs.firePropertyChange(BOARD_MOVE, null, board);
    }

    /**
     * Add the given integer to the game score.
     *
     * @param addToScore the given integer.
     */
    private void addToScore(int addToScore) {
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
