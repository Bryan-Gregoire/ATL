package esi.atl.g53735.view;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Represent the score of the game.
 *
 * @author g53735
 */
public class scoreFX extends Label {

    /**
     * Constructor of scoreFX.
     *
     */
    public scoreFX() {
        this.setTextFill(Paint.valueOf("#776e65"));
        this.setFont(Font.font("Arial", FontWeight.BOLD, 50));
    }
}
