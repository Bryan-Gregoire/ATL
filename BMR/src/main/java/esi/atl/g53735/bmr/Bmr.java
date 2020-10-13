package esi.atl.g53735.bmr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Represent the calculator of BMR.
 *
 * @author g53735
 */
public class Bmr extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start of the calculator.
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calcul du BMR");
        VBox vbox = new VBox(20);
        HBox hbox = new HBox();
        GridPane rootLeft = new GridPane();
        GridPane rootRight = new GridPane();

        rootLeft.setPadding(new Insets(8));
        rootRight.setPadding(new Insets(8));

        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        rootLeft.setAlignment(Pos.CENTER_LEFT);
        rootRight.setAlignment(Pos.BASELINE_RIGHT);

        rootLeft.setHgap(12);
        rootLeft.setVgap(10);
        rootRight.setHgap(12);
        rootRight.setVgap(10);

        // Coté gauche
        Text titleLeft = new Text("Données");
        titleLeft.setUnderline(true);
        titleLeft.setFill(Color.BLACK);
        titleLeft.setFont(Font.font("System", 12));
        GridPane.setConstraints(titleLeft, 0, 0);

        Label size = new Label("Taille (cm)");
        GridPane.setConstraints(size, 0, 1);

        Label weight = new Label("Poids (kg)");
        GridPane.setConstraints(weight, 0, 2);

        Label age = new Label("Age (années)");
        GridPane.setConstraints(age, 0, 3);

        Label gender = new Label("Sexe");
        GridPane.setConstraints(gender, 0, 4);

        Label lifeStyle = new Label("Style de vie");
        GridPane.setConstraints(lifeStyle, 0, 5);

        TextField sizePrompt = new TextField();
        sizePrompt.setPromptText("Taille en cm");
        GridPane.setConstraints(sizePrompt, 1, 1);

        TextField weightPrompt = new TextField();
        weightPrompt.setPromptText("Poids en kg");
        GridPane.setConstraints(weightPrompt, 1, 2);

        TextField agePrompt = new TextField();
        agePrompt.setPromptText("Age en années");
        GridPane.setConstraints(agePrompt, 1, 3);

        HBox sexBox = new HBox(10);
        GridPane.setConstraints(sexBox, 1, 4);

        ToggleGroup genderGroup = new ToggleGroup();

        RadioButton female = new RadioButton("Femme");
        female.setUserData("Femme");
        female.setToggleGroup(genderGroup);
        GridPane.setConstraints(female, 0, 0);

        RadioButton male = new RadioButton("Homme");
        male.setUserData("Homme");
        male.setToggleGroup(genderGroup);
        GridPane.setConstraints(male, 1, 0);

        ChoiceBox<ActivityEnum> box = new ChoiceBox<>();
        box.getItems().addAll(ActivityEnum.values());
        box.setValue(ActivityEnum.ACTIF);
        GridPane.setConstraints(box, 1, 5);

        sexBox.getChildren().addAll(female, male);
        rootLeft.getChildren().addAll(titleLeft, size, weight, age, gender,
                lifeStyle, sizePrompt, weightPrompt, agePrompt, sexBox, box);
        //fin coté gauche
        // Coté droit

        Text titleRight = new Text("Résultats");
        titleRight.setUnderline(true);
        titleRight.setFill(Color.BLACK);
        titleRight.setFont(Font.font("System", 12));
        GridPane.setConstraints(titleRight, 0, 0);

        Label bmr = new Label("BMR");
        GridPane.setConstraints(bmr, 0, 1);

        TextField bmrField = new TextField();
        GridPane.setConstraints(bmrField, 1, 1);
        bmrField.setEditable(false);

        Label calories = new Label("Calories");
        GridPane.setConstraints(calories, 0, 2);

        TextField caloriesField = new TextField();
        GridPane.setConstraints(caloriesField, 1, 2);
        caloriesField.setEditable(false);

        rootRight.getChildren().addAll(titleRight, bmr, bmrField, calories,
                caloriesField);
        //fin coté droit

        Button button = new Button("Calcul du BMR");
        button.setPrefWidth(480);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                if (buttonFailed(sizePrompt, weightPrompt, agePrompt,
                        genderGroup)) {
                    bmrField.setText("Failed!");
                    bmrField.setStyle("-fx-text-fill: red; -fx-font-size: "
                            + "12;");
                    caloriesField.setText("Failed!");
                    caloriesField.setStyle("-fx-text-fill: red; -fx-font-size: "
                            + "12;");
                } else {
                    int size = Integer.parseInt(sizePrompt.getText());
                    int weight = Integer.parseInt(weightPrompt.getText());
                    int age = Integer.parseInt(agePrompt.getText());
                    double activityLevel = getLevelActivity(box);
                    double calories;
                    double bmr;
                    if (genderGroup.getSelectedToggle().getUserData().toString()
                            .equals("Femme")) {
                        bmr = (9.6 * weight) + (1.8 * size) - (4.7 * age) + 655;
                        calories = bmr * activityLevel;
                    } else {
                        bmr = (13.7 * weight) + (5 * size) - (6.8 * age) + 66;
                        calories = bmr * activityLevel;
                    }
                    bmrField.setText(bmr + "");
                    bmrField.setStyle("-fx-text-fill: black; "
                            + "-fx-font-size: 12;");
                    caloriesField.setText(calories + "");
                    caloriesField.setStyle("-fx-text-fill: black; "
                            + "-fx-font-size: 12;");
                }

            }

        });

        hbox.getChildren().addAll(rootLeft, rootRight);
        vbox.getChildren().addAll(hbox, button);

        Scene scene = new Scene(vbox, 750, 500);
        scene.setCursor(Cursor.HAND);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
        vbox.requestFocus();
    }

    /**
     * String represent the level of activity.
     *
     * @param box the string.
     * @return the level of activity.
     */
    private Double getLevelActivity(ChoiceBox<ActivityEnum> box) {
        switch (box.getValue()) {
            case SEDENTAIRE:
                return 1.2;
            case PEUACTIF:
                return 1.375;
            case ACTIF:
                return 1.55;
            case FORTACTIF:
                return 1.725;
            case EXTREMENTACTIF:
                return 1.9;
        }
        return null;
    }

    /**
     * Check if the data is valid.
     *
     * @param sizePrompt the TextField of the size.
     * @param weightPrompt the TextField of the weight.
     * @param agePrompt The TextField of the Age.
     * @param genderGroup The group of button of the sex.
     * @return true if it is not valid otherwise false.
     */
    private boolean buttonFailed(TextField sizePrompt, TextField weightPrompt,
            TextField agePrompt, ToggleGroup genderGroup) {
        return sizePrompt.getText().isEmpty()
                || weightPrompt.getText().isEmpty()
                || agePrompt.getText().isEmpty()
                || genderGroup.getSelectedToggle() == null
                || !weightPrompt.getText().matches("\\d*")
                || !agePrompt.getText().matches("\\d*")
                || !sizePrompt.getText().matches("\\d*");
    }
}
