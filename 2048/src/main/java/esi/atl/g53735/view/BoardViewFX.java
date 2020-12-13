package esi.atl.g53735.view;

import esi.atl.g53735.model.Board;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Represent the game board in JavaFX.
 *
 * @author g53735
 */
public class BoardViewFX extends VBox {

    /**
     * Build a board based on the given board, composed of SquareFX.
     *
     * @param board the given board.
     */
    public void buildBoard(Board board) {
        if (!this.getChildren().isEmpty()) {
            this.getChildren().clear();
        }
        for (int i = 0; i < board.getNbRow(); i++) {
            HBox line = new HBox();
            for (int j = 0; j < board.getNbColumn(); j++) {
                line.getChildren().add(new SquareFX(board.getValue(i, j)));
            }
            line.setAlignment(Pos.CENTER);
            this.getChildren().add(line);
        }
    }
}
