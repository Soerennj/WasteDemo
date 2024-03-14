package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MonthLineChart extends LineChart<Number, Number> {
    ObservableList<XYChart.Data<Number, Number>> monthData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(monthData);

    public MonthLineChart() {
        super(new NumberAxis(0,31, 1), new NumberAxis(0,5000, 1000));
        getXAxis().setLabel("Days");
        getYAxis().setLabel("Waste (gram)");
        seriesData.setName("Waste 03-2024");
        this.getData().add(seriesData);
    }

    private void addData(int day, double measurement) {
        monthData.add(new XYChart.Data<>(day, measurement));
    }

    public void addDataMonth(ArrayList<TrashEntry> datalist) {
        for (TrashEntry trashData : datalist) {
            LocalDate date = LocalDate.parse(trashData.getTime().split(" ")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            int dayOfMonth = date.getDayOfMonth();
            double weight = Math.floor(trashData.getWeight() * 100) / 100;
            addData(dayOfMonth,weight);
        }
    }
}
