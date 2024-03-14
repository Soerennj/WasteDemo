package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class YearlyLineChart extends LineChart<Number, Number> {
    ObservableList<Data<Number, Number>> yearData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(yearData);

    public YearlyLineChart() {
        super(new NumberAxis(0,12,1), new NumberAxis(0,100,10));
        seriesData.setName("yearly data");
        this.getData().add(seriesData);
    }

    public void addData(int day, double measurement) {
        yearData.add(new XYChart.Data<>(day, measurement));
    }
}