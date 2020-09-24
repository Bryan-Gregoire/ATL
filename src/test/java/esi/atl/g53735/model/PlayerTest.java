package esi.atl.g53735.model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author g53735
 */
public class PlayerTest {

    
    /**
     * Test of getGold method, of class Player.
     */
    @Test
    public void testGetGold() {
        Player instance = new Player(new ArrayList<>());
        int expResult = 1000;
        int result = instance.getGold();
        assertEquals(expResult, result);
    }

    /**
     * Test of winGold method, of class Player.
     */
    @Test
    public void testWinGold() {
        int goldWin = 100;
        Player instance = new Player(new ArrayList<>());
        instance.winGold(goldWin);
        int result = instance.getGold();
        int expResult = 1100;
        assertEquals(expResult, result);
    }

    /**
     * Test of winGold method, of class Player.
     */
    @Test
    public void testWinGold2() {
        int goldWin = 500;
        Player instance = new Player(new ArrayList<>());
        instance.winGold(goldWin);
        int result = instance.getGold();
        int expResult = 1500;
        assertEquals(expResult, result);
    }

    /**
     * Test of loseGold method, of class Player.
     */
    @Test
    public void testLoseGold() {
        int goldLose = 100;
        Player instance = new Player(new ArrayList<>());
        instance.loseGold(goldLose);
        int result = instance.getGold();
        int expResult = 900;
        assertEquals(expResult, result);
    }

    /**
     * Test of loseGold method, of class Player.
     */
    @Test
    public void testLoseGold2() {
        int goldLose = 500;
        Player instance = new Player(new ArrayList<>());
        instance.loseGold(goldLose);
        int result = instance.getGold();
        int expResult = 500;
        assertEquals(expResult, result);
    }
}
