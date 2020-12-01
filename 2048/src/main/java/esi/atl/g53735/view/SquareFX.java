package esi.atl.g53735.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author g53735
 */
public class SquareFX extends Label {

    int value;

    public SquareFX(int value) {
        super();
        this.value = value;
        this.setText(this.value == 0 ? "0" : "" + this.value);
        this.setTextFill(Paint.valueOf("#776e65"));
        this.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        setBackgroundColor();
        this.setMinSize(125, 125);
        this.setTextAlignment(TextAlignment.CENTER);
        this.setAlignment(Pos.CENTER);
    }

    private void setBackgroundColor() {
        switch (this.value) {
            case 0:
            case 2:
                this.setStyle("-fx-background-color: #eee4da; ");
                break;
            case 4:
                this.setStyle("-fx-background-color: #eee1c9; ");
                break;
            case 8:
                this.setStyle("-fx-background-color: #f3b27a; ");
                break;
            case 16:
                this.setStyle("-fx-background-color: #f69664; ");
                break;
            case 32:
                this.setStyle("-fx-background-color: #f77c5f; ");
                break;
            case 64:
                this.setStyle("-fx-background-color: #f75f3b; ");
                break;
            case 128:
                this.setStyle("-fx-background-color:  #edd073; ");
                break;
            case 256:
                this.setStyle("-fx-background-color:  #edcc62; ");
                break;
            case 512:
                this.setStyle("-fx-background-color:  #edc950; ");
                break;
            case 1024:
                this.setStyle("-fx-background-color:  #edc53f; ");
                break;
            case 2048:
                this.setStyle("-fx-background-color:  #edc22e; ");
                break;
        }
    }
}
