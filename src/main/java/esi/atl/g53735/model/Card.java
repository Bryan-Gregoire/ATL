package esi.atl.g53735.model;

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
        if (color == null | value == null) {
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

    public int valueOfCard(Value value) {
        switch (value) {
            case ACE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 10;
            case QUEEN:
                return 10;
            case KING:
                return 10;
        }
        return 0;
    }
    
    
}
