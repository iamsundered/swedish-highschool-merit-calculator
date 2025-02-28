package org.polar.swedishmeritscorecalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ProgrammeInterfaceController {
    @FXML
    private void switchToProgramme() {
        SceneManager.changeScene("Creation_Interface.fxml");
        System.out.println("Creation_Interface.fxml");
    }

    private HighSchoolSystem main;

    public void setMainApp(HighSchoolSystem mainApp) {
        this.main = mainApp;

        // Load all program values in combobox (same as in CreationInterface).
        feedProgrammesOptions();
    }

    ArrayList<Program> newProgrammesList;
    private void loadProgrammesList() {
        newProgrammesList = main.getProgramsList();
    }

    @FXML
    ComboBox<Program> programmesOptions;
    @FXML
    ComboBox<Integer> pointsBox;

    private void feedProgrammesOptions() {
        loadProgrammesList();

        ObservableList<Program> observableProgrammesOptions = FXCollections.observableArrayList(newProgrammesList);
        programmesOptions.setItems(observableProgrammesOptions);

        // Sets the default selection using obeservablelist.
        if (!observableProgrammesOptions.isEmpty()) {
            programmesOptions.setValue(observableProgrammesOptions.get(0));
        }

        ArrayList<Integer> points = new ArrayList<>();

        points.add(50);
        points.add(100);
        points.add(150);
        points.add(200);

        ObservableList<Integer> observablePoints = FXCollections.observableArrayList(points);

        if (!observablePoints.isEmpty()) {
            pointsBox.setValue(observablePoints.get(0));
        }




    }

    private void triggerNewCourse() {

        char soGood = 'A';

        main.newCourse(programmesOptions.getValue(), pointsBox.setValue(pointsBox.getValue()), soGood);
    }


}
