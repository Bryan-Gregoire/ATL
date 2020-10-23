package esi.atl.g53735.bmr;

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

    private TextField bmrField;
    private TextField caloriesField;

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

    public void clearResult() {
        bmrField.clear();
        caloriesField.clear();
    }

    /**
     * Set a text and set a style to text.
     *
     */
    public void setError(String message) {
        bmrField.setText(message);
        bmrField.setStyle("-fx-text-fill: red; -fx-font-size: "
                + "12;");
        caloriesField.setText(message);
        caloriesField.setStyle("-fx-text-fill: red; -fx-font-size: "
                + "12;");
    }

    /**
     * Set the results in the given TextFields.
     *
     * @param bmr the result of the BMR.
     * @param calories the result of calories.
     */
    public void setResults(double bmr, double calories) {
        bmrField.setText(bmr + "");
        bmrField.setStyle("-fx-text-fill: black; "
                + "-fx-font-size: 12;");
        caloriesField.setText(calories + "");
        caloriesField.setStyle("-fx-text-fill: black; "
                + "-fx-font-size: 12;");
    }

    /**
     * Calculate the BMR of the female.
     *
     * @param weight the weight of the female.
     * @param size the size of the female.
     * @param age the age of the female.
     * @return the BMR.
     */
    public double femaleBMR(int weight, int size, int age) {
        return (9.6 * weight) + (1.8 * size) - (4.7 * age) + 655;
    }

    /**
     * Calculate the BMR of the male.
     *
     * @param weight the weight of the male.
     * @param size the size of the male.
     * @param age the age of the male.
     * @return the BMR.
     */
    public double maleBMR(int weight, int size, int age) {
        return (13.7 * weight) + (5 * size) - (6.8 * age) + 66;
    }

    /**
     * Check if the result of BMR is negative.
     *
     * @param bmr the BMR.
     * @return true if it is under zero else false.
     */
    public boolean BMRUnderZero(double bmr) {
        return bmr < 0;
    }

    /**
     * Calculate calorie expenditure.
     *
     * @param bmr the BMR.
     * @param levelActivity the level of activity.
     * @return the number of calories.
     */
    public double caloriesResult(double bmr, double levelActivity) {
        return bmr * levelActivity;
    }

}
