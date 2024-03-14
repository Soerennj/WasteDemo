package com.example.wastedemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private RadioButton btnDay, btnWeek, btnMonth, btnYear;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ComboBox<String> cBoxDepartment;

    @FXML
    private GridPane gridPeriodSelection;
    private WeekLineChart weekChart = new WeekLineChart();
    private MonthLineChart monthChart = new MonthLineChart();
    private YearLineChart yearChart = new YearLineChart();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayPeriodGrid(false);
        cBoxDepartment.getItems().addAll("Department. A");

        ToggleGroup toggleGroup = new ToggleGroup();
        btnDay.setToggleGroup(toggleGroup);
        btnWeek.setToggleGroup(toggleGroup);
        btnMonth.setToggleGroup(toggleGroup);
        btnYear.setToggleGroup(toggleGroup);

        cBoxDepartment.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setLineChart(weekChart);
                displayPeriodGrid(true);
            }
        });

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == btnDay) {
                System.out.println("daily");
            } else if (newValue == btnWeek) {
                setLineChart(weekChart);
                System.out.println("weekly");
            } else if (newValue == btnMonth) {
                setLineChart(monthChart);
                System.out.println("monthly");
            } else if (newValue == btnYear) {
                setLineChart(yearChart);
                System.out.println("yearly");
            }
        });
    }

    private void displayPeriodGrid(boolean display) {
        gridPeriodSelection.setVisible(display);
    }

    private void setLineChart(LineChart<Number, Number> lineChart) {
        this.borderPane.setCenter(null);
        this.borderPane.setCenter(lineChart);
    }
}