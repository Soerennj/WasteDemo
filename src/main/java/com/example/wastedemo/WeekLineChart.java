package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class WeekLineChart extends LineChart<Number, Number> {

    ObservableList<Data<Number, Number>> weekData = FXCollections.observableArrayList();
    XYChart.Series<Number, Number> seriesData = new XYChart.Series<>(weekData);

    public WeekLineChart() {
        super(new NumberAxis(0,7,1), new NumberAxis(0,5000,1000));
        seriesData.setName("Waste Week-11");
        getXAxis().setLabel("Days");
        getYAxis().setLabel("Waste (gram)");
        this.getData().add(seriesData);
    }

    public void addData(int day, double measurement) {
        weekData.add(new XYChart.Data<>(day, measurement));
    }

    public void addDataWeek(ArrayList<TrashEntry> datalist) {
        for (int i = 0; i < 14; i++) {
            TrashEntry data = datalist.get(i);
            LocalDate date = LocalDate.parse(data.getTime().split(" ")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            int dayOfWeek = date.getDayOfMonth();
            double weight = Math.floor(data.getWeight() * 100) / 100;
            addData(dayOfWeek, weight);
        }
    }
}