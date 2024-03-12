module com.example.wastedemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wastedemo to javafx.fxml;
    exports com.example.wastedemo;
}