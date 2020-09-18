package esi.atl.g53735.cards;

/**
 * Represent a card of the game.
 * 
 * @author Utilisateur
 */
public class Card {
    
    private Color color;
    private Value value;

    /**
     * Constructor of the card.
     * 
     * @param color the color of the card.
     * @param value the value of the card.
     */
    public Card(Color color, Value value) {
        if(color == null | value == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
        this.value = value;
    }

    /**
     * Get the color of the card.
     * 
     * @return 
     */
    public Color getColor() {
        return color;
    }

    /**
     * Get the value of the card.
     * 
     * @return 
     */
    public Value getValue() {
        return value;
    }

    /**
     * String that represent a card.
     * 
     * @return the string.
     */
    @Override
    public String toString() {
        return value + " of " + color;
    }
}
