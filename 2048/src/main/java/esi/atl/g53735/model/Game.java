package esi.atl.g53735.model;

/**
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
    
    @Override
    public LevelStatus getStatus() {
        return status;
    }
    
    @Override
    public void move(Direction direction) {
        board.moveValues(direction);
        board.addFreePlaces();
        board.setRandomValueBoard();
    }
}
