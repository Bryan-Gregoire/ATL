package esi.atl.g53735.main;

import esi.atl.g53735.controller.ControllerFX;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.model.Model;
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
        ViewFX view = new ViewFX();
        ControllerFX controller = new ControllerFX(game, view);
        view.setController(controller);
        controller.addModelListener(view);
        controller.startGame();
        view.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
