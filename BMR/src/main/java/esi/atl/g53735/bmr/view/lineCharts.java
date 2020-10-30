package esi.atl.g53735.bmr.view;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Utilisateur
 */
public class lineCharts extends VBox {

    private final XYChart.Series kgVsBMRMenSeries;
    private final XYChart.Series kgVsBMRWomenSeries;
    private final XYChart.Series kgVsCalMenSeries;
    private final XYChart.Series kgVsCalWomenSeries;
    private final XYChart.Series cmVsBMRMenSeries;
    private final XYChart.Series cmVsBMRWomenSeries;

    public lineCharts() {
        
        kgVsBMRMenSeries = new XYChart.Series();
        kgVsBMRWomenSeries = new XYChart.Series();
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Weight(kg)");
        yAxis.setLabel("BMR");
        kgVsBMRMenSeries.setName("MenData");
        kgVsBMRWomenSeries.setName("WomenData");
        LineChart chart1 = new LineChart(xAxis, yAxis);
        chart1.setTitle("Weight(kg) Vs BMR");
        chart1.getData().addAll(kgVsBMRMenSeries, kgVsBMRWomenSeries);

        kgVsCalMenSeries = new XYChart.Series();
        kgVsCalWomenSeries = new XYChart.Series();
        NumberAxis xAxis2 = new NumberAxis();
        NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("Weight(kg)");
        yAxis2.setLabel("Calories");
        kgVsCalMenSeries.setName("MenData");
        kgVsCalWomenSeries.setName("WomenData");
        LineChart chart2 = new LineChart(xAxis2, yAxis2);
        chart2.setTitle("Weight(kg) vs Calories");
        chart2.getData().addAll(kgVsCalMenSeries, kgVsCalWomenSeries);

        cmVsBMRMenSeries = new XYChart.Series();
        cmVsBMRWomenSeries = new XYChart.Series();
        NumberAxis xAxis3 = new NumberAxis();
        NumberAxis yAxis3 = new NumberAxis();
        xAxis3.setLabel("Height(cm)");
        yAxis3.setLabel("BMR");
        cmVsBMRMenSeries.setName("MenData");
        cmVsBMRWomenSeries.setName("WomenData");
        LineChart chart3 = new LineChart(xAxis3, yAxis3);
        chart3.setTitle("Height(cm) vs BMR");
        chart3.getData().addAll(cmVsBMRMenSeries, cmVsBMRWomenSeries);

        //TabPane du chart
        TabPane chartPane = new TabPane();

        Tab tab1 = new Tab("Weight(kg) vs BMR", chart1);
        Tab tab2 = new Tab("Weight(kg) vs Calories", chart2);
        Tab tab3 = new Tab("Height(cm) vs BMR", chart3);

        chartPane.getTabs().addAll(tab1, tab2, tab3);

        this.getChildren().add(chartPane);
    }

    public void addKgVsBMRMenSeriesData(int weight, double bmr) {
        kgVsBMRMenSeries.getData().add(new XYChart.Data<>(weight, bmr));
    }

    public void addKgVsBMRWomenSeriesData(int weight, double bmr) {
        kgVsBMRWomenSeries.getData().add(new XYChart.Data<>(weight, bmr));
    }

    public void addCmVsBMRMenSeriesData(int height, double bmr) {
        cmVsBMRMenSeries.getData().add(new XYChart.Data<>(height, bmr));
    }

    public void addCmVsBMRWomenSeriesData(int height, double bmr) {
        cmVsBMRWomenSeries.getData().add(new XYChart.Data<>(height, bmr));
    }

    public void addKgVsCalMenSeriesData(int weight, double calories) {
        kgVsCalMenSeries.getData().add(new XYChart.Data<>(weight, calories));
    }

    public void addKgVsCalWomenSeriesData(int weight, double calories) {
        kgVsCalWomenSeries.getData().add(new XYChart.Data<>(weight, calories));
    }

}
