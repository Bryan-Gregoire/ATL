package esi.atl.g53735.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author g53735
 */
public class scoreFX extends Label {

    public scoreFX() {
        this.setPadding(new Insets(10));
        this.setTextFill(Paint.valueOf("#776e65"));
        this.setFont(Font.font("Arial", FontWeight.BOLD, 50));
    }

}
