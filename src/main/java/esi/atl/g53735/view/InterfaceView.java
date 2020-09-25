package esi.atl.g53735.view;

import esi.atl.g53735.model.Players;
import java.util.List;

/**
 * Interface of the view.
 *
 * @author Utilisateur
 */
public interface InterfaceView {

    public void displayMessage(String message);

    public void displayScore(Players players);

    public void displayPlayerCards(List playerDeck);

    public void displayBankCards(List bankHand);

    public void displayWallet(int gold);

    public void displayWalletMinusBet(int wallet, int bet);

    public boolean askYesOrNo(String message);

    public boolean askTakeCard();

    public void displayPossibleGain(int bet);

    public int askBet();

}
