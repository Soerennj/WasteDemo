package com.example.wastedemo;

import javafx.collections.ObservableList;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LinechartUge extends LineChart<Number, Number> {

    NumberAxis xAxis = new NumberAxis(1, 7, 1);

    NumberAxis yAxis = new NumberAxis(0,100,10);
    XYChart.Series series = new XYChart.Series();
    public LinechartUge(Axis<Number> axis, Axis<Number> axis1) {
        super(axis, axis1);
        series.setName("Waste");
        getData().add(series);
        addData();
    }

    public LinechartUge(Axis<Number> axis, Axis<Number> axis1, ObservableList<Series<Number, Number>> observableList) {
        super(axis, axis1, observableList);
    }



    LineChart linechart = new LineChart(xAxis,yAxis);



    public void addData(){


        series.getData().add(new XYChart.Data<>(1, 10));
        series.getData().add(new XYChart.Data<>(2, 20));
        series.getData().add(new XYChart.Data<>(3, 30));
        series.getData().add(new XYChart.Data<>(4, 40));
        series.getData().add(new XYChart.Data<>(5, 50));
        series.getData().add(new XYChart.Data<>(6, 60));
        series.getData().add(new XYChart.Data<>(7, 70));

    }



}
