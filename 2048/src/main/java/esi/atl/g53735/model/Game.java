package esi.atl.g53735.model;

/**
 *
 * @author g53735
 */
public class Game implements Model {

    private final Board board;

    /**
     * Constructor of Game.
     *
     */
    public Game() {
        this.board = new Board();
        board.setRandomValueBoard();
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
    public void move(Direction direction) {
        board.moveValues(direction);
        board.setRandomValueBoard();
    }
}
