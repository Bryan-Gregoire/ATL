package esi.atl.g53735.view;

import java.util.List;
import java.util.Scanner;

/**
 * The view of the game.
 * 
 * @author g53735
 */
public class View implements InterfaceView {

    /**
     * Display the given message.
     * 
     * @param message the given message. 
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Display the score of a player.
     * 
     * @param score the score of the player/ 
     */
    @Override
    public void displayScore(int score) {
        System.out.println("You have a score of : " + score);
    }
    
    /**
     * Display the total score of the bank.
     * 
     * @param score the score to display. 
     */
    @Override
    public void displayBankScore(int score) {
        System.out.println("The bank have a score of " + score);
    }

    /**
     * Display the cards of a player.
     * 
     * @param playerHand the cards of the player.
     */
    @Override
    public void displayPlayerCards(List playerHand) {
        System.out.println("The cards in your hand: " + playerHand.toString());
    }
    
    /**
     * Display the cards of the bank.
     * 
     * @param bankHand the cards of the bank.
     */
    @Override
    public void displayBankCards(List bankHand) {
        System.out.println("The cards of the bank : " + bankHand.toString());
    }

    /**
     * Display how much money the player has.
     * 
     * @param gold the money of the player.
     */
    @Override
    public void displayWallet(int gold) {
        System.out.println("You have " + gold + " gold in your wallet");
    }
    
    
    /**
     * Display how much money the player has by withdrawing the bet.
     * 
     * @param wallet the money the player has
     * @param bet the bet of the player.
     */
    @Override
    public void displayWalletMinusBet(int wallet, int bet) {
        System.out.println("You have " + (wallet-bet) + " gold in your wallet");
    }

    /**
     * Ask if the player want to draw another card.
     * 
     * @return true if the player want a card else false. 
     */
    @Override
    public boolean askTakeCard() {
        return askYesOrNo("Do you want another card ?(y/yes or n/no) ");
    }

    /**
     * Display the possible gain of the player.
     * 
     * @param bet 
     */
    @Override
    public void displayPossibleGain(int bet) {
        System.out.println("The possible gain is " + 2 * bet);
    }
    
    /**
     * Ask how much the player want to bet.
     * 
     * @return the bet. 
     */
    @Override
    public int askBet() {
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
                && !"N".equals(ask) && !"NO".equals(ask)) {
            System.out.println("This is not correct");
            System.out.println("Enter y/yes or n/no: ");
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
