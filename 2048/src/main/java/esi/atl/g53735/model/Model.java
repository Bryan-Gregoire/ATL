package esi.atl.g53735.model;

/**
 *
 * @author g53735
 */
public interface Model {

    public Board getBoard();
    
    public LevelStatus getStatus();

    public void move(Direction direction);
}
