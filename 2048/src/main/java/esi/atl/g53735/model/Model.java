package esi.atl.g53735.model;

/**
 * Define methods that the class Game should implement.
 *
 * @author g53735
 */
public interface Model {

    public Board getBoard();

    public LevelStatus getStatus();

    public int getScore();
    
    public void setNewLevelStatus();

    public void move(Direction direction);
}
