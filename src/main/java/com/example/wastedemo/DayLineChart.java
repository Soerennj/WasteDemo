package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DayLineChart extends LineChart<Number, Number> {

    ObservableList<Data<Number, Number>> weekData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(weekData);

    public DayLineChart() {
        super(new NumberAxis(1,24,1), new NumberAxis(0,100,10));
        seriesData.setName("Waste");
        this.getData().add(seriesData);
    }

    public void addData(int day, double measurement) {
        weekData.add(new XYChart.Data<>(day, measurement));
    }
}