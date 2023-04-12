module com.example.scenebuildercalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.scenebuildercalculator to javafx.fxml;
    exports com.example.scenebuildercalculator;
}