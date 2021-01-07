//@pbt name in project name 


package esi.atl.g53735.main;

import esi.atl.g53735.controller.ControllerFX;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.model.Model;
import esi.atl.g53735.view.InterfaceViewFX;
import esi.atl.g53735.view.ViewFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Create the Controller and start the game.
 *
 * @author g53735
 */
public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Model game = new Game();
        InterfaceViewFX view = new ViewFX();
        ControllerFX controller = new ControllerFX(game, view);
        view.setController(controller);
        controller.addModelListener(view);
        controller.startGame(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
