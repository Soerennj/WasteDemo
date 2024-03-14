package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class MonthlyLineChart extends LineChart<Number, Number> {
    ObservableList<XYChart.Data<Number, Number>> monthData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(monthData);

    public MonthlyLineChart() {
        super(new NumberAxis(0,31, 1), new NumberAxis(0,100, 10));
        seriesData.setName("monthly data");
        this.getData().add(seriesData);
    }

    public void addData(int day, double measurement) {
        monthData.add(new XYChart.Data<>(day, measurement));
    }
}