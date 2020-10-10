package esi.atl.g53735.bmr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
 *
 * @author g53735
 */
public class Bmr extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calcul du BMR");
        VBox vbox = new VBox();
        HBox hbox = new HBox();
        GridPane rootLeft = new GridPane();
        GridPane rootRight = new GridPane();
        rootLeft.setPadding(new Insets(8));
        rootRight.setPadding(new Insets(8));
        vbox.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        rootLeft.setAlignment(Pos.CENTER_LEFT);
        rootRight.setAlignment(Pos.CENTER_RIGHT);
        rootLeft.setHgap(12);
        rootLeft.setVgap(5);
        rootRight.setHgap(5);
        rootRight.setVgap(5);

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

        ToggleGroup genderGroup = new ToggleGroup();

        RadioButton female = new RadioButton("Femme");
        female.setToggleGroup(genderGroup);
        GridPane.setConstraints(female, 1, 4);

        RadioButton male = new RadioButton("Homme");
        male.setToggleGroup(genderGroup);
        GridPane.setConstraints(male, 1, 4);
        male.setPadding(new Insets(0, 0, 0, 68));

        ChoiceBox<String> box = new ChoiceBox<>();
        box.getItems().addAll("Sédentaire", "Peu actif", "Actif", "Fort actif",
                "Extrêmement actif");
        GridPane.setConstraints(box, 1, 5);
        //button.setOnAction(e -> getLifeStyleChoice(box)); // qd je click sur le button je retourne la valeur choisis.

        rootLeft.getChildren().addAll(titleLeft, size, weight, age, gender,
                lifeStyle, sizePrompt, weightPrompt, agePrompt, male, female,
                box);

        hbox.getChildren().addAll(rootLeft, rootRight);
        vbox.getChildren().add(hbox);

        Text titleRight = new Text("Résultat");
        titleRight.setUnderline(true);
        titleRight.setFill(Color.BLACK);

        Scene scene = new Scene(vbox, 750, 500);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String getLifeStyleChoice(ChoiceBox<String> box) {
        return box.getValue();
    }

}
