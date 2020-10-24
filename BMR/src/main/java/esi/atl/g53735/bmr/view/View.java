package esi.atl.g53735.bmr.view;

import esi.atl.g53735.bmr.model.ActivityLevel;
import esi.atl.g53735.bmr.model.BMRFacade;
import esi.atl.g53735.bmr.model.Gender;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Represent the calculator of BMR.
 *
 * @author g53735
 */
public class View extends Application {
    
    private BMRFacade bmrFacade;
    private BMRData rootLeft;
    private BMResult rootRight;
    
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
        BorderPane root = new BorderPane();
        HBox containAll = new HBox();
        
        VBox leftContain = new VBox(10);      
        VBox rightContain = new VBox(10);
        
        HBox hbox = new HBox();
        rootLeft = new BMRData();
        rootRight = new BMResult();
        bmrFacade = new BMRFacade();
        
        leftContain.setAlignment(Pos.CENTER);
        rightContain.setAlignment(Pos.CENTER);
        hbox.setAlignment(Pos.CENTER);
        
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
                    
                    double calories;
                    double bmr;
                    
                    if (rootLeft.isFemale()) {
                        bmr = bmrFacade.femaleBMR();
                        calories = bmrFacade.caloriesResult(bmr);
                    } else {
                        bmr = bmrFacade.maleBMR();
                        calories = bmrFacade.caloriesResult(bmr);
                    }
                    if (bmrFacade.BMRUnderZero(bmr)) {
                        rootRight.setError("Failed !");
                        negatif.showAndWait();
                    } else {
                        rootRight.setResults(bmr, calories);
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
        
        LineChart chart1;
        XYChart.Series series1 = new XYChart.Series();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weight(kg)");
        yAxis.setLabel("BMR");
        series1.setName("MenData");
        chart1 = new LineChart(xAxis, yAxis);
        series1.getData().add(new XYChart.Data<>(1, 20));
        series1.getData().add(new XYChart.Data<>(2, 100));
        series1.getData().add(new XYChart.Data<>(3, 80));
        series1.getData().add(new XYChart.Data<>(4, 180));
        series1.getData().add(new XYChart.Data<>(5, 20));
        series1.getData().add(new XYChart.Data<>(6, -10));
        chart1.getData().add(series1);

        //Fin bouton bas
        hbox.getChildren().addAll(rootLeft, rootRight);
        leftContain.getChildren().addAll(hbox, calculate, clear);
        
        rightContain.getChildren().add(chart1);
        
        containAll.getChildren().addAll(leftContain,rightContain);
        root.setTop(menuBar);
        root.setCenter(containAll);
        
        Scene scene = new Scene(root, 1000, 600);
        scene.setCursor(Cursor.HAND);
        scene.setFill(Color.LIGHTGRAY);
        primaryStage.setScene(scene);
        primaryStage.show();
        leftContain.requestFocus();
    }
}
