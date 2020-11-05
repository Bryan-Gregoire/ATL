package esi.atl.g53735.main;

import esi.atl.g53735.controller.Controller;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.view.View;

/**
 * Create the Controller and start the game.
 *
 * @author g53735
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("           2048");
        System.out.println("===========================");
        Controller controller = new Controller(new Game(), new View());
        controller.startGame();
    }
}
