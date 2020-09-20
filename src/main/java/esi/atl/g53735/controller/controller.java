package esi.atl.g53735.controller;

import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.InterfaceView;
import esi.atl.g53735.view.View;

/**
 *
 * @author g53735
 */
public class Controller {
    
    private final Model game;
    private final InterfaceView view;

    public Controller(Model game, View interfaceView) {
        this.game = game;
        this.view = interfaceView;
    }
    
    public void startGame(){
        view.displayMessage("BlackJack");
        view.displayMessage("============================");
        
    }
}
