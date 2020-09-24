package esi.atl.g53735.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author g53735
 */
public class GameTest {
    
    private Player player;
    private Bank bank;
    private Deck gameDeck;
    private int bet;
    
//    @BeforeEach
//    public void setUp() {
//      player = new Player(new ArrayList<> ());
//      bank = new Bank(new ArrayList<> ());
//      this.gameDeck = new Deck();
//      bet = 0;
//    }

    /**
     * Test of getGameDeck method, of class Game.
     */
    @Test
    public void testSizeGameDeck() {
        gameDeck = new Deck();
        int result = gameDeck.getList().size();
        int expResult = 52;
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of getPlayer method, of class Game.
//     */
//    @Test
//    public void testGetPlayer() {
//        Player expResult = null;
//        Player result = instance.getPlayer();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBet method, of class Game.
//     */
//    @Test
//    public void testGetBet() {
//        System.out.println("getBet");
//        Game instance = null;
//        int expResult = 0;
//        int result = instance.getBet();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setBet method, of class Game.
//     */
//    @Test
//    public void testSetBet() {
//        System.out.println("setBet");
//        int bet = 0;
//        Game instance = null;
//        instance.setBet(bet);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of resetScore method, of class Game.
//     */
//    @Test
//    public void testResetScore() {
//        System.out.println("resetScore");
//        Game instance = null;
//        instance.resetScore();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getBank method, of class Game.
//     */
//    @Test
//    public void testGetBank() {
//        System.out.println("getBank");
//        Game instance = null;
//        Bank expResult = null;
//        Bank result = instance.getBank();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getGold method, of class Game.
//     */
//    @Test
//    public void testGetGold() {
//        System.out.println("getGold");
//        Game instance = null;
//        int expResult = 0;
//        int result = instance.getGold();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of beginHandPlayer method, of class Game.
//     */
//    @Test
//    public void testBeginHandPlayer() {
//        System.out.println("beginHandPlayer");
//        Game instance = null;
//        instance.beginHandPlayer();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of playerDrawCard method, of class Game.
//     */
//    @Test
//    public void testPlayerDrawCard() {
//        System.out.println("playerDrawCard");
//        Players players = null;
//        Game instance = null;
//        instance.playerDrawCard(players);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkAbove21 method, of class Game.
//     */
//    @Test
//    public void testCheckAbove21() {
//        System.out.println("checkAbove21");
//        Players players = null;
//        Game instance = null;
//        boolean expResult = false;
//        boolean result = instance.checkAbove21(players);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of resetCards method, of class Game.
//     */
//    @Test
//    public void testResetCards() {
//        System.out.println("resetCards");
//        List<Card> hand = null;
//        Deck gameDeck = null;
//        Game instance = null;
//        instance.resetCards(hand, gameDeck);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of winGold method, of class Game.
//     */
//    @Test
//    public void testWinGold() {
//        System.out.println("winGold");
//        Game instance = null;
//        instance.winGold();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of loseGold method, of class Game.
//     */
//    @Test
//    public void testLoseGold() {
//        System.out.println("loseGold");
//        Game instance = null;
//        instance.loseGold();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
