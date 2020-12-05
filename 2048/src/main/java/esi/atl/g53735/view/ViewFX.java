package esi.atl.g53735.view;

import esi.atl.g53735.controller.ControllerFX;
import esi.atl.g53735.model.Board;
import esi.atl.g53735.model.Direction;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.model.LevelStatus;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author g53735
 */
public class ViewFX extends Application implements PropertyChangeListener,
        InterfaceViewFX {

    private ControllerFX controller;

    private final ListView listView;
    private final VBox root;
    private final VBox containBoard;
    private final HBox containGame;
    private Label lblScore;

    public ViewFX() {
        root = new VBox();
        this.containBoard = new VBox();
        containGame = new HBox();

        listView = new ListView();
        listView.setMouseTransparent(true); //Transparent to mouse event.
        listView.setFocusTraversable(false);//so that you couldn't interact 
        //with the node by focusing in other ways.
    }

    /**
     * Set a controler.
     *
     * @param controller the given controller to set.
     */
    public void setController(ControllerFX controller) {
        this.controller = controller;
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
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
                controller.startGame();
                DateFormat format = new SimpleDateFormat("hh:mm:ss");
                Calendar calendar = Calendar.getInstance();
                String lgListView = format.format(calendar.getTime())
                        + " - Partie recommencer";
                listView.getItems().add(lgListView);
                root.requestFocus();
            }
        });

        lblScore = new Label("Score : " + 0);
        lblScore.setPadding(new Insets(10));
        lblScore.setTextFill(Paint.valueOf("#776e65"));
        lblScore.setFont(Font.font("Arial", FontWeight.BOLD, 50));

        containGame.getChildren().addAll(containBoard, listView);
        containGame.setAlignment(Pos.CENTER);
        containGame.setSpacing(5);

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(title, containGame, lblScore, again);
        root.setOnKeyPressed((t) -> {
            keyDirection(t);
        });

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
        if (evt.getPropertyName().equals(Game.SCORE)) {
            lblScore.setText("Score : " + evt.getNewValue());
        }
        if (evt.getPropertyName().equals(Game.BOARD_MOVE)) {
            buildBoard((Board) evt.getNewValue());
        }
        if (evt.getPropertyName().equals(Game.STATUS)) {
            DateFormat format = new SimpleDateFormat("hh:mm:ss");
            Calendar calendar = Calendar.getInstance();
            String lgStatus;

            if (evt.getNewValue() == LevelStatus.IN_PROGRESS) {
                lgStatus = format.format(calendar.getTime())
                        + " - Bievenu au 2048.";
                listView.getItems().add(lgStatus);
            } else if (evt.getNewValue() == LevelStatus.FAIL) {
                String lgGameOver = format.format(calendar.getTime())
                        + " - Partie terminée";
                lgStatus = format.format(calendar.getTime())
                        + " - Vous avez perdu.";
                listView.getItems().addAll(lgGameOver, lgStatus);

            } else if (evt.getNewValue() == LevelStatus.WIN) {
                String lgEndGame = format.format(calendar.getTime())
                        + " - Partie terminée";
                lgStatus = format.format(calendar.getTime())
                        + " - Vous avez gagner.";
                listView.getItems().addAll(lgEndGame, lgStatus);
            }
        }
    }

    /**
     * Build a board based on the given board, composed of SquareFX.
     *
     * @param board the given board.
     */
    private void buildBoard(Board board) {
        if (!containBoard.getChildren().isEmpty()) {
            containBoard.getChildren().clear();
        }
        for (int i = 0; i < board.getNbRow(); i++) {
            HBox line = new HBox();
            for (int j = 0; j < board.getNbColumn(); j++) {
                line.getChildren().add(new SquareFX(board.getValue(i, j)));
            }
            line.setAlignment(Pos.CENTER);
            containBoard.getChildren().add(line);
        }
    }

    /**
     * Move the values of the game board in the direction of the event.
     *
     * @param e the direction which move.
     */
    public void keyDirection(KeyEvent e) {
        switch (e.getCode()) {
            case UP:
                this.controller.move(Direction.UP);
                break;
            case DOWN:
                this.controller.move(Direction.DOWN);
                break;
            case RIGHT:
                this.controller.move(Direction.RIGHT);
                break;
            case LEFT:
                this.controller.move(Direction.LEFT);
                break;
            default:
        }
    }
}
