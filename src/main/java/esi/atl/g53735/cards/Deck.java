package esi.atl.g53735.cards;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Represent the deck of the game.
 *
 * @author Utilisateur
 */
public class Deck {

    private ArrayList<Card> list;

    /**
     * Constructor of the deck.
     *
     */
    public Deck() {
        this.list = new ArrayList<>();
        for (Color color : Color.values()) {
            for (Value value : Value.values()) {
                this.list.add(new Card(color, value));
            }
        }
    }

    public ArrayList<Card> getList() {
        return list;
    }
    

    /**
     * Shuffle the deck.
     *
     */
    public void shuffle() {
        Collections.shuffle(list);
    }

    /**
     * Check if the deck is empty.
     *
     * @return true if is empty else false.
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Remove a card of the deck.
     *
     * @return the removed card.
     */
    public Card hit() {
        return list.remove(0);
    }

    /**
     * The size of the deck.
     *
     * @return the size.
     */
    public int size() {
        return this.list.size();
    }

    /**
     * String that represent the cards in the deck.
     *
     * @return the string that represent the cards in the deck.
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
