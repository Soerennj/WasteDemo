package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DayLineChart extends LineChart<Number, Number> {
    ObservableList<Data<Number, Number>> dayData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(dayData);

    public DayLineChart() {
        super(new NumberAxis(1,24,1), new NumberAxis(0,100,10));
        seriesData.setName("Waste");
        this.getData().add(seriesData);
    }

    private void addData(int day, double measurement) {
        dayData.add(new XYChart.Data<>(day, measurement));
    }
}
