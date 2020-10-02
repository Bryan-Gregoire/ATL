package esi.atl.g53735.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;


/**
 *
 * @author Utilisateur
 */
public class CardTest {

    public CardTest() {
    }

    /**
     * Test of getColor method, of class Card.
     */
    @Test
    public void testGetColor() {
        Card instance = new Card(Color.CLUB, Value.ACE);
        Color expResult = Color.CLUB;
        Color result = instance.getColor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Card.
     */
    @Test
    public void testGetColorFalse() {
        Card instance = new Card(Color.SPADE, Value.ACE);
        Color expResult = Color.HEART;
        Color result = instance.getColor();
        assertFalse(expResult == result);
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        Card instance = new Card(Color.HEART, Value.KING);
        Value expResult = Value.KING;
        Value result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue2() {
        Card instance = new Card(Color.SPADE, Value.SIX);
        Value expResult = Value.FOUR;
        Value result = instance.getValue();
        assertFalse(expResult == result);
    }

    /**
     * Test of valueOfCard method, of class Card.
     */
    @Test
    public void testValueOfCard() {
        Value value = Value.EIGHT;
        Card instance = new Card(Color.CLUB, value);
        int expResult = 8;
        int result = instance.valueOfCard(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOfCard method, of class Card.
     */
    @Test
    public void testValueOfCard2() {
        Value value = Value.QUEEN;
        Card instance = new Card(Color.CLUB, value);
        int expResult = 10;
        int result = instance.valueOfCard(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of valueOfCard method, of class Card.
     */
    @Test
    public void testValueOfCardFalse() {
        Value value = Value.QUEEN;
        Card instance = new Card(Color.CLUB, value);
        int expResult = 11;
        int result = instance.valueOfCard(value);
        assertFalse(expResult == result);
    }

}
