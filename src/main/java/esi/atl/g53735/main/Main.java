package esi.atl.g53735.main;

import esi.atl.g53735.controller.Controller;
import esi.atl.g53735.model.Bank;
import esi.atl.g53735.model.Deck;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.model.Player;
import esi.atl.g53735.view.View;
import java.util.ArrayList;

/**
 * The main
 *
 * @author Utilisateur
 */
public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller(new Game(new Player(new ArrayList<>()), new Bank(new ArrayList<>()), new Deck()), new View());
        controller.startGame();
    }
}
