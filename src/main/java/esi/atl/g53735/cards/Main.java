package esi.atl.g53735.cards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Utilisateur
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Error, respect the consign");
        }
        int n = Integer.parseInt(args[0]);
        if (n < 0 | n > 52) {
            throw new IllegalArgumentException("Error, respect the consign");
        }
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < n; i++) {
           deck.hit();
        }
        System.out.println(deck.toStringBuilder());
    }
}
