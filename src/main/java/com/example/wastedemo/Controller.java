package com.example.wastedemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
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
    private GridPane gridPane;
    @FXML
    private ComboBox<String> ComboBoxDepartment;

    private final DayLineChart dayChart = new DayLineChart();
    private final WeekLineChart weekChart = new WeekLineChart();
    private final MonthLineChart monthChart = new MonthLineChart();
    private final YearLineChart yearChart = new YearLineChart();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayPeriodGrid(false);

        ComboBoxDepartment.getItems().addAll("Sønderborg", "Rødekro", "Kliplev");

        ToggleGroup toggleGroup = new ToggleGroup();
        btnDay.setToggleGroup(toggleGroup);
        btnWeek.setToggleGroup(toggleGroup);
        btnMonth.setToggleGroup(toggleGroup);
        btnYear.setToggleGroup(toggleGroup);

        ComboBoxDepartment.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                //setLineChart(dayChart);
                displayPeriodGrid(true);
                if (newValue.equals("Sønderborg")) {

                } else if (newValue.equals("Rødekro")) {

                } else if (newValue.equals("Kliplev")) {

                }
            }
        });

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == btnDay) {
                setLineChart(dayChart);
            } else if (newValue == btnWeek) {
                setLineChart(weekChart);
            } else if (newValue == btnMonth) {
                setLineChart(monthChart);
            } else if (newValue == btnYear) {
                setLineChart(yearChart);
            }
        });
    }

    private void displayPeriodGrid(boolean display) {
        gridPane.setVisible(display);
    }

    private void setLineChart(LineChart<Number, Number> lineChart) {
        this.borderPane.setCenter(null);
        this.borderPane.setCenter(lineChart);
    }
}