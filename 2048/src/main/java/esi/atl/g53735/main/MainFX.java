package esi.atl.g53735.main;

import esi.atl.g53735.controller.ControllerFX;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.view.ViewFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author g53735
 */
public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Game game = new Game();
        ViewFX view = new ViewFX(game);
        ControllerFX controller = new ControllerFX(game, view);
        controller.addModelListener(view);
        view.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
