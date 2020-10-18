package esi.atl.g53735.bmr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
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

        vbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.setAlignment(Pos.CENTER);
        rootLeft.setAlignment(Pos.CENTER_LEFT);
        rootRight.setAlignment(Pos.BASELINE_RIGHT);

        rootLeft.setHgap(12);
        rootLeft.setVgap(10);
        rootRight.setHgap(12);
        rootRight.setVgap(10);

        //Menu
        MenuBar menuBar = new MenuBar();
        Menu menuFile = new Menu("File");

        MenuItem exit = new MenuItem("Exit");
        exit.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                System.exit(0);
            }
        });
        menuFile.getItems().add(exit);
        menuBar.getMenus().addAll(menuFile);
        //Fin Menu

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

        TextField sizeField = new TextField();
        sizeField.setPromptText("Taille en cm");
        GridPane.setConstraints(sizeField, 1, 1);

        TextField weightField = new TextField();
        weightField.setPromptText("Poids en kg");
        GridPane.setConstraints(weightField, 1, 2);

        TextField ageField = new TextField();
        ageField.setPromptText("Age en années");
        GridPane.setConstraints(ageField, 1, 3);

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
                lifeStyle, sizeField, weightField, ageField, sexBox, box);
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
        bmrField.setPromptText("Résultats du BMR");
        bmrField.setMouseTransparent(true);
        GridPane.setConstraints(bmrField, 1, 1);
        bmrField.setEditable(false);

        Label calories = new Label("Calories");
        GridPane.setConstraints(calories, 0, 2);

        TextField caloriesField = new TextField();
        caloriesField.setPromptText("Dépense en calories");
        caloriesField.setMouseTransparent(true);
        GridPane.setConstraints(caloriesField, 1, 2);
        caloriesField.setEditable(false);

        rootRight.getChildren().addAll(titleRight, bmr, bmrField, calories,
                caloriesField);
        //fin coté droit

        //boutons du bas
        Alert inputZero = new Alert(Alert.AlertType.ERROR);
        inputZero.setTitle("Erreur");
        inputZero.setHeaderText("Erreur #0");
        inputZero.setContentText("0 n'est pas un nombre valide "
                + "pour une donnée");

        Button calculate = new Button("Calcul du BMR");
        calculate.setPrefWidth(480);
        calculate.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                if (resultFailed(sizeField, weightField, ageField,
                        genderGroup, inputZero)) {
                    failedStyle(bmrField, caloriesField);
                } else {
                    int size = Integer.parseInt(sizeField.getText());
                    int weight = Integer.parseInt(weightField.getText());
                    int age = Integer.parseInt(ageField.getText());
                    double calories;
                    double bmr;
                    if (genderGroup.getSelectedToggle().getUserData().toString()
                            .equals("Femme")) {
                        bmr = femaleBMR(weight, size, age);
                        calories = caloriesResult(bmr, box);
                    } else {
                        bmr = maleBMR(weight, size, age);
                        calories = caloriesResult(bmr, box);
                    }
                    setTextResult(bmrField, bmr, caloriesField, calories);

                }

            }

        });

        Button clear = new Button("Effacer les données");
        clear.setPrefWidth(480);
        clear.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                sizeField.clear();
                weightField.clear();
                ageField.clear();
                genderGroup.selectToggle(null);
                bmrField.clear();
                caloriesField.clear();
            }
        });

        sizeField.addEventFilter(KeyEvent.KEY_TYPED,
                new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!event.getCharacter().matches("\\d") 
                        || sizeField.getText().length() > 2) {
                    event.consume();

                }
            }
        });
        weightField.addEventFilter(KeyEvent.KEY_TYPED,
                new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!event.getCharacter().matches("\\d") 
                        || weightField.getText().length() > 2) {
                    event.consume();

                }
            }
        });
        ageField.addEventFilter(KeyEvent.KEY_TYPED,
                new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!event.getCharacter().matches("\\d") 
                        || ageField.getText().length() > 1) {
                    event.consume();

                }
            }
        });
        //Fin bouton bas

        hbox.getChildren().addAll(rootLeft, rootRight);
        vbox.getChildren().addAll(menuBar, hbox, calculate, clear);

        Scene scene = new Scene(vbox, 750, 400);
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
     * @param sizeField the TextField of the size.
     * @param weightField the TextField of the weight.
     * @param ageField The TextField of the Age.
     * @param genderGroup The group of button of the sex.
     * @return true if it is not valid otherwise false.
     */
    private boolean resultFailed(TextField sizeField, TextField weightField,
            TextField ageField, ToggleGroup genderGroup, Alert alert) {
        return sizeField.getText().isEmpty()
                || weightField.getText().isEmpty()
                || ageField.getText().isEmpty()
                || genderGroup.getSelectedToggle() == null
                || falseData(sizeField, weightField, ageField, alert);
    }

    /**
     * Calculate the BMR of the female.
     *
     * @param weight the weight of the female.
     * @param size the size of the female.
     * @param age the age of the female.
     * @return the BMR.
     */
    private double femaleBMR(int weight, int size, int age) {
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
    private double maleBMR(int weight, int size, int age) {
        return (13.7 * weight) + (5 * size) - (6.8 * age) + 66;
    }

    /**
     * Calculate calorie expenditure.
     *
     * @param bmr the BMR.
     * @param box the ChoiceBox of the Activity level.
     * @return the number of calories.
     */
    private double caloriesResult(double bmr, ChoiceBox<ActivityEnum> box) {
        return bmr * getLevelActivity(box);
    }

    /**
     * Set a text and set a style to text.
     *
     * @param bmr The field to set.
     * @param calories The field to set.
     */
    private void failedStyle(TextField bmr, TextField calories) {
        bmr.setText("Failed!");
        bmr.setStyle("-fx-text-fill: red; -fx-font-size: "
                + "12;");
        calories.setText("Failed!");
        calories.setStyle("-fx-text-fill: red; -fx-font-size: "
                + "12;");
    }

    /**
     * Set the results in the given TextFields.
     *
     * @param bmrField field to set the BMR result.
     * @param bmr the result of the BMR.
     * @param caloriesField field to set the calories result.
     * @param calories the result of calories.
     */
    private void setTextResult(TextField bmrField, double bmr,
            TextField caloriesField, double calories) {
        bmrField.setText(bmr + "");
        bmrField.setStyle("-fx-text-fill: black; "
                + "-fx-font-size: 12;");
        caloriesField.setText(calories + "");
        caloriesField.setStyle("-fx-text-fill: black; "
                + "-fx-font-size: 12;");
    }

    /**
     * Check if the data is realistic.
     *
     * @param sizeField TextField of the size.
     * @param weightField TextField of the weight.
     * @param ageField TextField of the age.
     * @return true if data is not realistic else false.
     */
    private boolean falseData(TextField sizeField, TextField weightField,
            TextField ageField, Alert alert) {
        int size = Integer.parseInt(sizeField.getText());
        int weight = Integer.parseInt(weightField.getText());
        int age = Integer.parseInt(ageField.getText());

        if (size == 0 || weight == 0 || age == 0) {
            alert.showAndWait();
            return true;
        }

        return size > 300 || weight > 500 || age > 80;
    }
}
