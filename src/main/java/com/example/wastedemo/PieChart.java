package com.example.wastedemo;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class PieChart extends Application{

    HashMap<String, Integer> testStats = new HashMap<>();
    int sum = 0;
    @Override public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("McDonalds Waste");
        stage.setWidth(500);
        stage.setHeight(500);

        double sonderborgSum = 0;
        double kliplevSum = 0;
        double rodekroSum = 0;

        FileRead.getSonderborg();

        for (TrashEntry o: FileRead.alSonderborg
             ) {
            sonderborgSum += o.weight;
        }

        for (TrashEntry o : FileRead.alKliplev
        ) {
            kliplevSum += o.weight;
        }

        for (TrashEntry o : FileRead.alRodekro
        ) {
            rodekroSum += o.weight;
        }

        testStats.put("Sønderborg", (int)Math.round(sonderborgSum));
        testStats.put("Kliplev", (int)Math.round(kliplevSum));
        testStats.put("Rødekro", (int)Math.round(rodekroSum));

        for (String i : testStats.keySet())
        {
            sum += testStats.get(i);
        }



        ObservableList<javafx.scene.chart.PieChart.Data> pieChartData =
                FXCollections.observableArrayList();

        for (String i : testStats.keySet())
        {
            int data = branchPercentage(testStats.get(i));
            pieChartData.add(new javafx.scene.chart.PieChart.Data(i + String.format(" - %d", data) + "%", data));
        }
        final javafx.scene.chart.PieChart chart = new javafx.scene.chart.PieChart(pieChartData);

        chart.setTitle("Waste chart");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public int branchPercentage (int waste)
    {
        return ((int)Math.round(((double)waste/sum)*100));
    }
    public static void main(String[] args) {
        launch(args);
    }
}