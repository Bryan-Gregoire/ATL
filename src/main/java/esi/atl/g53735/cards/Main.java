package esi.atl.g53735.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Utilisateur
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Error, respect the rules");
        }
        if (!isStringInteger(args[0])) {
            throw new IllegalArgumentException("Error, not a number");
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
        System.out.println(deck.toString());
    }

    private int enterInteger(String message) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(message);
        while (!keyboard.hasNextInt()) {
            keyboard.next();
            System.out.println("not an integer, try again");
            System.out.print(message);
        }
        return keyboard.nextInt();
    }

    public static boolean isStringInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
