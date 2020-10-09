package esi.atl.g53735.bmr;

import java.awt.Label;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
             
        Label taille = new Label("Taille (cm)");
        Label poids = new Label("Poids (kg)");
        Label age  = new Label("Age (années)");
        Label sexe = new Label("Sexe");
        Label styleDeVie = new Label("Style de vie");
        
        
        
        Text titleLeft = new Text("Données");
        titleLeft.setUnderline(true);
        titleLeft.setFill(Color.BLACK);

        Text titleRight = new Text("Résultat");
        titleRight.setUnderline(true);
        titleRight.setFill(Color.BLACK);
        //root.setCenter(helloText);

        Scene scene = new Scene(vbox, 1000, 750);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
