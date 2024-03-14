package com.example.wastedemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private RadioButton btnDay, btnWeek, btnMonth, btnYear;
    @FXML
    private BorderPane borderPane;
    @FXML
    public ComboBox<String> cBoxSpecific;
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
        displayGrid(false);
        cBoxSpecific.getItems().addAll( "Week", "Month","Year");
        ComboBoxDepartment.getItems().addAll("Sønderborg", "Kliplev");



        ToggleGroup toggleGroup = new ToggleGroup();
        btnDay.setToggleGroup(toggleGroup);
        btnWeek.setToggleGroup(toggleGroup);
        btnMonth.setToggleGroup(toggleGroup);
        btnYear.setToggleGroup(toggleGroup);

        ComboBoxDepartment.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setLineChart(dayChart);
                toggleGroup.selectToggle(btnDay);
                displayGrid(true);
                if (newValue.equals("Sønderborg")) {
                    dayChart.addDataDay(FileRead.getSonderborg());
                    weekChart.addDataWeek(FileRead.getSonderborg());
                    monthChart.addDataMonth(FileRead.getSonderborg());
                    yearChart.addDataYear(FileRead.getSonderborg());
                } else if (newValue.equals("Kliplev")) {
                    dayChart.addDataDay(FileRead.getKliplev());
                    weekChart.addDataWeek(FileRead.getKliplev());
                    monthChart.addDataMonth(FileRead.getKliplev());
                    yearChart.addDataYear(FileRead.getKliplev());
                }
            }
        });

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == btnDay) {
                setLineChart(dayChart);
                cBoxSpecific.setVisible(false);
            } else if (newValue == btnWeek) {
                setLineChart(weekChart);
                cBoxSpecific.getItems().clear();
                cBoxSpecific.getItems().addAll(weekSpecific);
                cBoxSpecific.setVisible(true);
            } else if (newValue == btnMonth) {
                setLineChart(monthChart);
                cBoxSpecific.getItems().clear();
                cBoxSpecific.getItems().addAll(monthSpecific);
                cBoxSpecific.setVisible(true);
            } else if (newValue == btnYear) {
                setLineChart(yearChart);
                cBoxSpecific.getItems().clear();
                cBoxSpecific.getItems().addAll(yearSpecific);
                cBoxSpecific.setVisible(true);
            }
        });


    }

    private void displayGrid(boolean display) {
        gridPane.setVisible(display);
    }

    private void setLineChart(LineChart<Number, Number> lineChart) {
        this.borderPane.setCenter(null);
        this.borderPane.setCenter(lineChart);
    }


    private final ObservableList<String> weekSpecific = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52");
    private final ObservableList<String> monthSpecific = FXCollections.observableArrayList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
    private final ObservableList<String> yearSpecific = FXCollections.observableArrayList("2002", "2023", "2024");

}