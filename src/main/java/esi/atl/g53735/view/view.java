package esi.atl.g53735.view;

import esi.atl.g53735.model.Card;
import esi.atl.g53735.model.Color;
import esi.atl.g53735.model.Deck;
import esi.atl.g53735.model.Value;

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
    public void displayPlayerDeck(Deck playerDeck) {
        for (int i = 0; i < playerDeck.size(); i++) {
            displayValueCards(playerDeck.getList().get(i).getValue());
            displayColorCards(playerDeck.getList().get(i).getColor());
        }
    }
    
    @Override
    public void displayRemovedCard(Card card) {
      
    }
    

    private void displayValueCards(Value value) {
        switch (value) {
            case ACE:
                System.out.print("AS ");
                break;
            case TWO:
                System.out.print("DEUX ");
                break;
            case THREE:
                System.out.print("TROIS ");
                break;
            case FOUR:
                System.out.print("QUATRE ");
                break;
            case FIVE:
                System.out.print("CINQ ");
                break;
            case SIX:
                System.out.print("SIX ");
                break;
            case SEVEN:
                System.out.print("SEPT ");
                break;
            case EIGHT:
                System.out.print("HUIT ");
                break;
            case NINE:
                System.out.print("NEUF ");
                break;
            case TEN:
                System.out.print("DIX ");
                break;
            case JACK:
                System.out.print("VALET ");
                break;
            case QUEEN:
                System.out.print("DAME ");
                break;
            case KING:
                System.out.print("ROI ");
        }
    }

    private void displayColorCards(Color color) {
        switch (color) {
            case CLUB:
                System.out.println("de " + "\033[102m TREFLE \033[0m");
                break;
            case DIAMOND:
                System.out.println("de " + "\033[41m CARREAU \033[0m");
                break;
            case HEART:
                System.out.println("de " + "\033[101m COEUR \033[0m");
                break;
            case SPADE:
                System.out.println("de " + "\033[30;1m PIQUE \033[0m");
                break;
        }
    }
    
}
