package esi.atl.g53735.view;

import esi.atl.g53735.controller.ControllerFX;
import esi.atl.g53735.model.Board;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.model.LevelStatus;
import java.beans.PropertyChangeEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Represent the view of the game in JavaFX.
 *
 * @author g53735
 */
public class ViewFX extends Application implements InterfaceViewFX {

    private ControllerFX controller;

    private final ListViewFX listView;
    private final BoardViewFX containBoard;
    private final scoreFX lblScore;

    /**
     * Constructor of ViewFX.
     *
     */
    public ViewFX() {
        //@pbt always this or never
        this.containBoard = new BoardViewFX();
        listView = new ListViewFX();
        lblScore = new scoreFX();
    }

    /**
     * Set a controler.
     *
     * @param controller the given controller to set.
     */
    @Override
    public void setController(ControllerFX controller) {
        this.controller = controller;
    }

    /**
     * Start of the view.
     *
     * @param stage the stage.
     */
    @Override
    public void start(Stage stage) {
        VBox root = new VBox();
        HBox containGame = new HBox();
        stage.setTitle("2048");

        Label title = new Label("2048");
        title.setTextFill(Paint.valueOf("#776e65"));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 75));
        title.setPadding(new Insets(10));

        Button again = new Button("Recommencer");
        again.setStyle("-fx-background-color: #8f7a66");
        again.setTextFill(Paint.valueOf("#f9f6f2"));
        again.setFont(Font.font("Clear sans", FontWeight.BOLD, 20));
        again.setPrefSize(250, 30);

        again.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                controller.restartGame();
                //@pbt update view with propertychange or "Demande de restart"
                listView.addMessageList(" - Partie recommencée");
                root.requestFocus();
            }
        });

        Button exit = new Button("Exit");
        exit.setStyle("-fx-background-color: #8f7a66");
        exit.setTextFill(Paint.valueOf("#f9f6f2"));
        exit.setFont(Font.font("Clear sans", FontWeight.BOLD, 20));
        exit.setPrefSize(250, 30);

        exit.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                //@pbt or Platform.exit();
                System.exit(0);
            }
        });

        containGame.getChildren().addAll(containBoard, listView);
        containGame.setAlignment(Pos.CENTER);
        containGame.setSpacing(5);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(title, containGame, lblScore, again, exit);
        root.setOnKeyPressed((t) -> {
            controller.keyDirection(t);
        });
        root.setSpacing(10);
        root.setStyle("-fx-background-color: #faf8ef");

        Scene scene = new Scene(root, 1000, 750);
        scene.setCursor(Cursor.HAND);
        stage.setScene(scene);
        stage.show();
        root.requestFocus();
    }

    /**
     * Change property of event.
     *
     * @param evt the event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //@pbt view update with model information. 
        if (evt.getPropertyName().equals(Game.SCORE)) {
            if ((int) evt.getOldValue() == -2) {
                listView.addMessageList(" - Mouvement impossible ");
            } else {
                lblScore.setText("Score : " + evt.getNewValue());
            }
        }
        if (evt.getPropertyName().equals(Game.BOARD_MOVE)) {
            containBoard.buildBoard((Board) evt.getNewValue());
        }
        if (evt.getPropertyName().equals(Game.STATUS)) {
            if (evt.getNewValue() == LevelStatus.IN_PROGRESS) {
                listView.addMessageList(" - Bievenu au 2048.");
            } else if (evt.getNewValue() == LevelStatus.FAIL) {
                listView.addMessageList(" - Partie terminée");
                listView.addMessageList(" - Vous avez perdu.");
            } else if (evt.getNewValue() == LevelStatus.WIN) {
                listView.addMessageList(" - Partie terminée");
                listView.addMessageList(" - Vous avez gagner.");
            }
        }
    }
}
