package esi.atl.g53735.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g53735
 */
public class GameTest {

    /**
     * Test of setNewLevelStatus method, of class Game.
     */
    @Test
    public void testSetNewLevelStatus() {
        Game instance = new Game(new Board(new int[][]{
            {2, 4, 8, 16},
            {32, 64, 128, 256},
            {512, 1024, 1024, 512},
            {256, 128, 64, 32}
        }));
        LevelStatus result = instance.getStatus();
        LevelStatus expResult = LevelStatus.NOT_STARTED;

        instance.startStatus();
        LevelStatus result2 = instance.getStatus();
        LevelStatus expResult2 = LevelStatus.IN_PROGRESS;

        instance.getBoard().addFreePlaces();
        instance.setNewLevelStatus();
        LevelStatus result3 = instance.getStatus();
        LevelStatus expResult3 = LevelStatus.IN_PROGRESS;

        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of setNewLevelStatus method, of class Game.
     */
    @Test
    public void testSetNewLevelStatusFAIL() {
        Game instance = new Game(new Board(new int[][]{
            {2, 4, 8, 16},
            {32, 64, 128, 256},
            {512, 1024, 2, 512},
            {256, 128, 64, 32}
        }));
        instance.getBoard().addFreePlaces();
        instance.setNewLevelStatus();
        LevelStatus result = instance.getStatus();
        LevelStatus expResult = LevelStatus.FAIL;

        assertEquals(expResult, result);
    }

    /**
     * Test of setNewLevelStatus method, of class Game.
     */
    @Test
    public void testSetNewLevelStatusWIN() {
        Game instance = new Game(new Board(new int[][]{
            {2, 4, 8, 16},
            {32, 64, 128, 256},
            {512, 2048, 2, 512},
            {256, 128, 64, 32}
        }));
        instance.getBoard().addFreePlaces();
        instance.setNewLevelStatus();
        LevelStatus result = instance.getStatus();
        LevelStatus expResult = LevelStatus.WIN;

        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveScoreUp() {
        Direction direction = Direction.UP;
        Game instance = new Game(new Board(new int[][]{
            {2, 2, 0, 0},
            {0, 2, 0, 16},
            {4, 0, 0, 16},
            {4, 16, 0, 0}
        }));
        instance.move(direction);
        int result = instance.getScore();
        int expResult = 44;
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveScoreDown() {
        Direction direction = Direction.DOWN;
        Game instance = new Game(new Board(new int[][]{
            {2, 2, 0, 2},
            {0, 2, 8, 0},
            {4, 0, 8, 0},
            {4, 16, 0, 2}
        }));
        instance.move(direction);
        int result = instance.getScore();
        int expResult = 32;
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveScoreLeft() {
        Direction direction = Direction.LEFT;
        Game instance = new Game(new Board(new int[][]{
            {2, 0, 0, 2},
            {0, 2, 2, 0},
            {4, 0, 4, 0},
            {4, 16, 0, 2}
        }));
        instance.move(direction);
        int result = instance.getScore();
        int expResult = 16;
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Game.
     */
    @Test
    public void testMoveScoreRight() {
        Direction direction = Direction.RIGHT;
        Game instance = new Game(new Board(new int[][]{
            {2, 2, 0, 2},
            {2, 0, 0, 2},
            {4, 8, 8, 0},
            {4, 16, 0, 2}
        }));
        instance.move(direction);
        int result = instance.getScore();
        int expResult = 24;
        assertEquals(expResult, result);
    }
}
