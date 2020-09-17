package esi.atl.g53735.cards;

/**
 *
 * @author Utilisateur
 */
public class Card {
    
    private Color color;
    private Value value;

    public Card(Color color, Value value) {
        if(color == null | value == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + " of " + color;
    }
}
