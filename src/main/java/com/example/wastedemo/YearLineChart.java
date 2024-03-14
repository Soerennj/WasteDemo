package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class YearLineChart extends LineChart<Number, Number> {
    ObservableList<Data<Number, Number>> yearData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(yearData);

    public YearLineChart() {
        super(new NumberAxis(0,12,1), new NumberAxis(0,5000,1000));
        getXAxis().setLabel("Months");
        getYAxis().setLabel("Waste (gram)");
        seriesData.setName("Waste 2024");
        this.getData().add(seriesData);
    }

    public void addData(int day, double measurement) {
        yearData.add(new XYChart.Data<>(day, measurement));
    }

    public void addDataYear(ArrayList<TrashEntry> datalist) {
        double totalWeight = 0;
        for (TrashEntry trashData : datalist) {
            double weight = Math.floor(trashData.getWeight() * 100) / 100;
            totalWeight += weight;
        }
        double averageWeight = totalWeight / datalist.size();
        addData(3, averageWeight);
    }
}