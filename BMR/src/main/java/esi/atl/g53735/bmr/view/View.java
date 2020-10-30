package esi.atl.g53735.bmr.view;

import esi.atl.g53735.bmr.model.ActivityLevel;
import esi.atl.g53735.bmr.model.BMRFacade;
import esi.atl.g53735.bmr.model.Gender;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represent the calculator of BMR.
 *
 * @author g53735
 */
public class View extends Application implements PropertyChangeListener {

    private BMRFacade bmrFacade;
    private BMRData rootLeft;
    private BMResult rootRight;
    private lineCharts tabCharts;

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
        VBox root = new VBox();
        HBox containAll = new HBox();

        VBox leftContain = new VBox(10);
        tabCharts = new lineCharts();

        HBox gridContain = new HBox();
        rootLeft = new BMRData();
        rootRight = new BMResult();
        bmrFacade = new BMRFacade();
        bmrFacade.addPropertChangeListener(this);

        gridContain.setAlignment(Pos.CENTER);
        leftContain.setAlignment(Pos.CENTER);
        tabCharts.setAlignment(Pos.CENTER);
        containAll.setAlignment(Pos.CENTER);

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

        //Alertes Pour calcule 
        Alert errorZero = new Alert(Alert.AlertType.ERROR);
        errorZero.setTitle("Erreur");
        errorZero.setHeaderText("Erreur #0");
        errorZero.setContentText("0 n'est pas un nombre valide "
                + "pour une donnée");

        Alert negatif = new Alert(Alert.AlertType.ERROR);
        negatif.setTitle("Erreur #-1");
        negatif.setHeaderText("Résultat négatif");
        negatif.setContentText("Le résultat du BMR est négatif");
        //Fin Alertes

        //boutons du bas
        Button calculate = new Button("Calcul du BMR");
        calculate.setPrefWidth(480);
        calculate.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {

                if (rootLeft.notValidData(errorZero)) {
                    rootRight.setError("Failed !");
                } else {
                    int size = rootLeft.getSize();
                    int weight = rootLeft.getWeight();
                    int age = rootLeft.getAge();
                    ActivityLevel activity = rootLeft.getActivity();
                    Gender gender = rootLeft.getGender();
                    bmrFacade.setData(size, weight, age, activity, gender);
                    try {
                        double bmr = bmrFacade.calculBMR();
                        bmrFacade.caloriesResult(bmr);
                    } catch (IllegalStateException e) {
                        rootRight.setError("Failed !");
                        negatif.showAndWait();
                    }
                }
            }
        });

        Button clear = new Button("Effacer les données");
        clear.setPrefWidth(480);
        clear.addEventHandler(ActionEvent.ACTION,
                new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                rootLeft.clearData();
                rootRight.clearResult();
            }
        });
        //Fin bouton du bas

        gridContain.getChildren().addAll(rootLeft, rootRight);
        leftContain.getChildren().addAll(gridContain, calculate, clear);

        containAll.getChildren().addAll(leftContain, tabCharts);
        root.getChildren().addAll(menuBar, containAll);

        Scene scene = new Scene(root, 1500, 750);
        scene.setCursor(Cursor.HAND);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
        leftContain.requestFocus();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(BMRFacade.CALCUL_BMR)) {
            if (bmrFacade.getGenderPerson().equals(Gender.HOMME)) {
                tabCharts.addKgVsBMRMenSeriesData(bmrFacade.getWeightPerson(),
                        (double) evt.getNewValue());
                tabCharts.addCmVsBMRMenSeriesData(bmrFacade.getHeightPerson(),
                        (double) evt.getNewValue());
            } else {
                tabCharts.addKgVsBMRWomenSeriesData(bmrFacade.getWeightPerson(),
                        (double) evt.getNewValue());
                tabCharts.addCmVsBMRWomenSeriesData(bmrFacade.getHeightPerson(),
                        (double) evt.getNewValue());
            }
            rootRight.setBMR((double) evt.getNewValue());
        }
        if (evt.getPropertyName().equals(BMRFacade.CALCUL_CALORIE)) {
            if (bmrFacade.getGenderPerson().equals(Gender.HOMME)) {
                tabCharts.addKgVsCalMenSeriesData(bmrFacade.getWeightPerson(),
                        (double) evt.getNewValue());
            } else {
                tabCharts.addKgVsCalWomenSeriesData(bmrFacade.getWeightPerson(),
                        (double) evt.getNewValue());
            }
        }
        rootRight.setCalories((double) evt.getNewValue());
    }
}
