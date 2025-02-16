module org.polar.swedishmeritscorecalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens org.polar.swedishmeritscorecalculator to javafx.fxml;
    exports org.polar.swedishmeritscorecalculator;
}