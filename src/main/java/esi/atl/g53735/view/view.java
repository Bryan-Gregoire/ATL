package esi.atl.g53735.view;

import esi.atl.g53735.model.Card;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author g53735
 */
public class View implements InterfaceView {

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayScore(int score) {
        System.out.println("You have a score of : " + score);
    }

    @Override
    public void displayPlayerCards(List playerHand) {
        System.out.println("The cards in your hand: " + playerHand.toString());
    }

    @Override
    public void displayTakenCard(Card card) {
        System.out.print("The drawen card is  : " + card.toString());
    }

    @Override
    public boolean askTakeCard() {
        return askYesOrNo("Do you want another card ? ");
    }

    @Override
    public void displayGain(int gold) {
        System.out.println("The possible gain is " + 2 * gold);
    }

    @Override
    public void displayError(String errorMessage) {
        System.out.println("Error : " + errorMessage);
    }

    @Override
    public int askBet(String message) {
        return enterInteger("How much do you want bet ? : ");
    }

    /**
     * Ask to enter a cardinal direction.
     *
     * @param message The given message.
     * @return the given direction.
     */
    @Override
    public boolean askYesOrNo(String message) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println(message);
        String ask = keyboard.nextLine().toUpperCase();
        while (!"Y".equals(ask) && !"YES".equals(ask)
                && !"N".equals(ask) && !"NO".equals(ask)
                && !"NON".equals(ask)) {
            System.out.println("This is not correct");
            System.out.println("Enter y/yes or n/no/non: ");
            ask = keyboard.nextLine().toUpperCase();
        }
        return ask.toUpperCase().equals("Y") || ask.toUpperCase().equals("YES");
    }

    /**
     * Ask a integer, while it is not a integer, ask again.
     *
     * @param message the given message to display.
     * @return the given integer.
     */
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
}
