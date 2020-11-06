package esi.atl.g53735.model;

/**
 * Bring together the elements necessary for the game to present a facade to the
 * view.
 *
 * @author g53735
 */
public class Game implements Model {

    private final Board board;
    private LevelStatus status = LevelStatus.NOT_STARTED;

    /**
     * Constructor of Game.
     *
     */
    public Game() {
        this.board = new Board();
        status = LevelStatus.IN_PROGRESS;
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
        return this.board.getScore();
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
    }

    /**
     * Check and set the new status of the game.
     *
     */
    @Override
    public void setNewLevelStatus() {
        if (this.board.winEnd()) {
            this.status = LevelStatus.WIN;
        } else if (this.board.loseEnd()) {
            this.status = LevelStatus.FAIL;
        }
    }

    /**
     * Move the values of the game board.
     *
     * @param direction the direction which move.
     */
    @Override
    public void move(Direction direction) {
        board.moveValues(direction);
        board.addFreePlaces();
        board.setRandomValueBoard();
        setNewLevelStatus();
    }
}
