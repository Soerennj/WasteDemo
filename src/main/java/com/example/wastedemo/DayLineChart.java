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

public class DayLineChart extends LineChart<Number, Number> {

    ObservableList<Data<Number, Number>> dayData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(dayData);

    public DayLineChart() {
        super(new NumberAxis(0,24,1), new NumberAxis(0,5000,1000));
        getXAxis().setLabel("Hours");
        getYAxis().setLabel("Waste (gram)");
        seriesData.setName("Waste 15-03-2024");
        this.getData().add(seriesData);
    }

    public void addData(int day, double measurement) {
        dayData.add(new XYChart.Data<>(day, measurement));
    }

    public void addDataDay(ArrayList<TrashEntry> datalist) {
        for (int i = 0; i < 2; i++) {
            TrashEntry data = datalist.get(i);
            LocalDateTime dateTime = LocalDateTime.parse(data.getTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
            int hourOfDay = dateTime.getHour();
            double weight = Math.floor(data.getWeight() * 100) / 100;
            addData(hourOfDay, weight);
        }
    }
}