package esi.atl.g53735.model;

import java.beans.PropertyChangeListener;

/**
 * Define methods that the class Game should implement.
 *
 * @author g53735
 */
public interface Model {

    /**
     * Get the board.
     *
     * @return the board.
     */
    public Board getBoard();

    /**
     * Get the LevelStatus.
     *
     * @return the levelStatus.
     */
    public LevelStatus getStatus();

    /**
     * Get the score.
     *
     * @return the score.
     */
    public int getScore();

    /**
     * Check if the game is lose or win and set the status, else do nothing.
     *
     */
    public void setNewLevelStatus();

    /**
     * Set status to say the game has started.
     */
    public void startStatus();

    /**
     * Move the values of the board in the given direction.
     *
     * @param direction the direction which move.
     */
    public void move(Direction direction);

    /**
     * Add the given listener to the model.
     *
     * @param listener the given listener to add.
     */
    public void addPropertChangeListener(PropertyChangeListener listener);

    /**
     * Remove the given listener.
     *
     * @param listener the given listener to remove.
     */
    public void removePropertyChangeListener(PropertyChangeListener listener);
}
