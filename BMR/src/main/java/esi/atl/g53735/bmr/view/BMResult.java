package esi.atl.g53735.bmr.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Utilisateur
 */
public class BMResult extends GridPane {

    private final TextField bmrField;
    private final TextField caloriesField;

    public BMResult() {
        this.setHgap(12);
        this.setVgap(10);
        this.setAlignment(Pos.BASELINE_RIGHT);
        this.setPadding(new Insets(8));

        Text titleRight = new Text("Résultats");
        titleRight.setUnderline(true);
        titleRight.setFill(Color.BLACK);
        titleRight.setFont(Font.font("System", 12));
        GridPane.setConstraints(titleRight, 0, 0);

        Label bmr = new Label("BMR");
        GridPane.setConstraints(bmr, 0, 1);

        bmrField = new TextField();
        bmrField.setPromptText("Résultats du BMR");
        bmrField.setMouseTransparent(true);
        GridPane.setConstraints(bmrField, 1, 1);
        bmrField.setEditable(false);

        Label calories = new Label("Calories");
        GridPane.setConstraints(calories, 0, 2);

        caloriesField = new TextField();
        caloriesField.setPromptText("Dépense en calories");
        caloriesField.setMouseTransparent(true);
        GridPane.setConstraints(caloriesField, 1, 2);
        caloriesField.setEditable(false);

        this.getChildren().addAll(titleRight, bmr, bmrField, calories,
                caloriesField);
    }

    public void setBMR(double bmr) {
        bmrField.setText(bmr + "");
        bmrField.setStyle("-fx-text-fill: black;");
    }

    public void setCalories(double calories) {
        caloriesField.setText(calories + "");
        caloriesField.setStyle("-fx-text-fill: black; ");
    }

    public void clearResult() {
        bmrField.clear();
        caloriesField.clear();
    }

    /**
     * Set a text and set a style to text.
     *
     * @param message
     */
    public void setError(String message) {
        bmrField.setText(message);
        bmrField.setStyle("-fx-text-fill: red; -fx-font-size: "
                + "12;");
        caloriesField.setText(message);
        caloriesField.setStyle("-fx-text-fill: red; -fx-font-size: "
                + "12;");
    }
}
