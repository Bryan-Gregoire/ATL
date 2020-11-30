package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;
import esi.atl.g53735.model.Direction;
import esi.atl.g53735.model.Game;
import esi.atl.g53735.model.Model;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

    private final Game model;
    private Label lblScore;
    private Label title;
    private VBox root;
    private VBox containBoard;

    public ViewFX(Game facadeModel) {
        this.model = facadeModel;
    }

    /**
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        root = new VBox();
        containBoard = new VBox();

        title = new Label("2048");
        title.setTextFill(Paint.valueOf("#776e65"));
        title.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        title.setPadding(new Insets(10));

        this.buildBoard(this.model.getBoard());

        lblScore = new Label("Score : " + this.model.getScore());
        lblScore.setPadding(new Insets(10));
        lblScore.setTextFill(Paint.valueOf("#776e65"));
        lblScore.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(title, containBoard, lblScore);
        Scene scene = new Scene(root, 1500, 750);
        scene.setOnKeyPressed((t) -> {
            keyDirection(t, this.model);
        });
        scene.setCursor(Cursor.HAND);
        scene.setFill(Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Game.SCORE)) {
            lblScore.setText("Score : " + this.model.getScore());
        }
        if (evt.getPropertyName().equals(Game.BOARD_MOVE)) {
            buildBoard(this.model.getBoard());
        }

    }

    private void buildBoard(Board board) {
        containBoard.getChildren().clear();
        for (int i = 0; i < board.getNbRow(); i++) {
            HBox line = new HBox();
            for (int j = 0; j < board.getNbColumn(); j++) {
                line.getChildren().add(new Square(board.getValue(i, j)));
            }
            line.setAlignment(Pos.CENTER);
            containBoard.getChildren().add(line);
        }
    }

    public void keyDirection(KeyEvent e, Model game) {
        switch (e.getCode()) {
            case UP:
                game.move(Direction.UP);
                break;
            case DOWN:
                game.move(Direction.DOWN);
                break;
            case RIGHT:
                game.move(Direction.RIGHT);
                break;
            case LEFT:
                game.move(Direction.LEFT);
                break;
            default:
        }
    }
}
