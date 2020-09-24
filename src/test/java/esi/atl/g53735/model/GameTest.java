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

    @BeforeEach
    public void setUp() {
        player = new Player(new ArrayList<>());
        bank = new Bank(new ArrayList<>());
        gameDeck = new Deck();
        bet = 0;
    }

    /**
     * Test of getGameDeck method, of class Game.
     */
    @Test
    public void testSizeGameDeck() {
        Deck instance = gameDeck;
        int result = instance.getList().size();
        int expResult = 52;
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameDeck method, of class Game.
     */
    @Test
    public void testSizeGameDeck2() {
        Player instance = player;
        Deck deck = gameDeck;
        instance.takeCard(deck);
        int result = gameDeck.getList().size();
        int expResult = 51;
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameDeck method, of class Game.
     */
    @Test
    public void testSizeGameDeck3() {
        Game instance = new Game(player, bank, gameDeck);
        instance.playerDrawCard(instance.getPlayer());
        instance.playerDrawCard(instance.getPlayer());
        instance.playerDrawCard(instance.getPlayer());
        int result = instance.getGameDeck().size();
        int expResult = 49;
        assertEquals(expResult, result);
    }

    /**
     * Test of resetScore method, of class Game.
     */
    @Test
    public void testResetScore() {
        Game instance = new Game(player, bank, gameDeck);
        instance.getGameDeck().shuffle();
        instance.playerDrawCard(instance.getPlayer());
        instance.playerDrawCard(instance.getBank());
        instance.resetScore();
        assertTrue(instance.getPlayer().getScore() == 0
                && instance.getPlayer().getScore() == 0);
    }

    /**
     * Test of resetScore method, of class Game.
     */
    @Test
    public void testResetScore2() {
        Game instance = new Game(player, bank, gameDeck);
        instance.getGameDeck().shuffle();
        instance.playerDrawCard(instance.getPlayer());
        instance.playerDrawCard(instance.getPlayer());
        instance.playerDrawCard(instance.getPlayer());
        instance.playerDrawCard(instance.getBank());
        instance.playerDrawCard(instance.getBank());
        instance.playerDrawCard(instance.getBank());
        instance.resetScore();
        assertTrue(instance.getPlayer().getScore() == 0
                && instance.getPlayer().getScore() == 0);
    }

    /**
     * Test of resetScore method, of class Game.
     */
    @Test
    public void testResetScore3() {
        Game instance = new Game(player, bank, gameDeck);
        instance.getGameDeck().shuffle();
        instance.playerDrawCard(instance.getBank());
        instance.playerDrawCard(instance.getBank());
        instance.playerDrawCard(instance.getBank());
        instance.resetScore();
        assertTrue(instance.getBank().getScore() == 0
                && instance.getPlayer().getScore() == 0);
    }

    /**
     * Test of beginHandPlayer method, of class Game.
     */
    @Test
    public void testBeginHandPlayerIsEmpty() {
        Game instance = new Game(player, bank, gameDeck);
        instance.beginHandPlayer();
        boolean result = instance.getPlayer().getHand().isEmpty();
        assertFalse(result);
    }

    /**
     * Test of beginHandPlayer method, of class Game.
     */
    @Test
    public void testBeginHandPlayer() {
        Game instance = new Game(player, bank, gameDeck);
        instance.beginHandPlayer();
        boolean result = instance.getPlayer().getHand().size() == 2;
        assertTrue(result);
    }

    /**
     * Test of beginHandPlayer method, of class Game.
     */
    @Test
    public void testBeginHandPlayer2() {
        Game instance = new Game(player, bank, gameDeck);
        instance.beginHandPlayer();
        instance.beginHandPlayer();
        boolean result = instance.getPlayer().getHand().size() == 4;
        assertTrue(result);
    }

    /**
     * Test of playerDrawCard method, of class Game.
     */
    @Test
    public void testPlayerDrawCard() {
        Game instance = new Game(player, bank, gameDeck);
        instance.playerDrawCard(player);
        int result = instance.getPlayer().getHand().size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of playerDrawCard method, of class Game.
     */
    @Test
    public void testPlayerDrawCard2() {
        Game instance = new Game(player, bank, gameDeck);
        instance.playerDrawCard(player);
        instance.playerDrawCard(player);
        instance.playerDrawCard(player);
        int result = instance.getPlayer().getHand().size();
        int expResult = 3;
        assertEquals(expResult, result);
    }

    /**
     * Test of playerDrawCard method, of class Game.
     */
    @Test
    public void testBankDrawCard() {
        Game instance = new Game(player, bank, gameDeck);
        instance.playerDrawCard(bank);
        int result = instance.getBank().getHand().size();
        int expResult = 1;
        assertEquals(expResult, result);
    }

    /**
     * Test of playerDrawCard method, of class Game.
     */
    @Test
    public void testBankDrawCard2() {
        Game instance = new Game(player, bank, gameDeck);
        instance.playerDrawCard(bank);
        instance.playerDrawCard(bank);
        instance.playerDrawCard(bank);
        instance.playerDrawCard(bank);
        int result = instance.getBank().getHand().size();
        int expResult = 4;
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAbove21 method, of class Game.
     */
    @Test
    public void testCheckAbove21() {
        Game instance = new Game(player, bank, gameDeck);
        player.takeCard(gameDeck);
        player.takeCard(gameDeck);
        boolean expResult = false;
        boolean result = instance.checkAbove21(player);
        assertEquals(expResult, result);
    }

    /**
     * Test of resetCards method, of class Game.
     */
    @Test
    public void testResetCardsOfPlayer() {
        Game instance = new Game(player, bank, gameDeck);
        player.takeCard(gameDeck);
        player.takeCard(gameDeck);
        instance.resetCards(player.getHand(), gameDeck);
        boolean result = player.getHand().isEmpty();
        assertTrue(result);
    }

    /**
     * Test of resetCards method, of class Game.
     */
    @Test
    public void testResetCardsOfBank() {
        Game instance = new Game(player, bank, gameDeck);
        bank.takeCard(gameDeck);
        bank.takeCard(gameDeck);
        instance.resetCards(bank.getHand(), gameDeck);
        boolean result = bank.getHand().isEmpty();
        assertTrue(result);
    }

    /**
     * Test of resetCards method, of class Game.
     */
    @Test
    public void testResetCards3() {
        Game instance = new Game(player, bank, gameDeck);
        bank.takeCard(gameDeck);
        bank.takeCard(gameDeck);
        instance.resetCards(bank.getHand(), gameDeck);
        int result = gameDeck.getList().size();
        int expResult = 52;
        assertEquals(expResult, result);
    }

    /**
     * Test of resetCards method, of class Game.
     */
    @Test
    public void testResetCards4() {
        Game instance = new Game(player, bank, gameDeck);
        bank.takeCard(gameDeck);
        bank.takeCard(gameDeck);
        player.takeCard(gameDeck);
        player.takeCard(gameDeck);
        instance.resetCards(bank.getHand(), gameDeck);
        instance.resetCards(player.getHand(), gameDeck);
        int result = gameDeck.getList().size();
        int expResult = 52;
        assertEquals(expResult, result);
    }

    /**
     * Test of winGold method, of class Game.
     */
    @Test
    public void testWinGold() {
        Game instance = new Game(player, bank, gameDeck);
        instance.setBet(100);
        instance.winGold();
        int result = instance.getGold();
        int expResult = 1100;
        assertEquals(expResult, result);
    }

    /**
     * Test of winGold method, of class Game.
     */
    @Test
    public void testWinGold2() {
        Game instance = new Game(player, bank, gameDeck);
        instance.winGold();
        int result = instance.getGold();
        int expResult = 1000;
        assertEquals(expResult, result);

    }

    /**
     * Test of loseGold method, of class Game.
     */
    @Test
    public void testLoseGold() {
        Game instance = new Game(player, bank, gameDeck);
        instance.loseGold();
        int result = instance.getGold();
        int expResult = 1000;
        assertEquals(expResult, result);
    }

    /**
     * Test of loseGold method, of class Game.
     */
    @Test
    public void testLoseGold2() {
        Game instance = new Game(player, bank, gameDeck);
        instance.setBet(250);
        instance.loseGold();
        int result = instance.getGold();
        int expResult = 750;
        assertEquals(expResult, result);
    }
}
