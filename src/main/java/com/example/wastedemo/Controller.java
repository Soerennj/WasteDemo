package com.example.wastedemo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private RadioButton btnDaily;

    @FXML
    private RadioButton btnMonthly;

    @FXML
    private RadioButton btnWeekly;

    @FXML
    private RadioButton btnYearly;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private ComboBox<String> cBoxDepartment;

    @FXML
    private GridPane gridPeriodSelection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayPeriodGrid(false);
        cBoxDepartment.getItems().addAll("Department. A");

        ToggleGroup toggleGroup = new ToggleGroup();
        btnDaily.setToggleGroup(toggleGroup);
        btnWeekly.setToggleGroup(toggleGroup);
        btnMonthly.setToggleGroup(toggleGroup);
        btnYearly.setToggleGroup(toggleGroup);

        cBoxDepartment.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {

            }
            if (newValue != null) {
                System.out.println("you selected something");
                MonthlyLineChart test = new MonthlyLineChart();
                BorderPane.setCenter(test);
                displayPeriodGrid(true);
            }
        });

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == btnDaily) {
                System.out.println("daily!");
            }
        });
    }

    private void displayPeriodGrid(boolean display) {
        gridPeriodSelection.setVisible(display);
    }
}