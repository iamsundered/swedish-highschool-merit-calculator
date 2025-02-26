package org.polar.swedishmeritscorecalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CreationInterfaceController {

    // Scene Controll:
    private Parent root;
    private HighSchoolSystem main;



    public void setMain(HighSchoolSystem main) {
        this.main = main;
    }
    public void setRoot(Parent root) {
        this.root = root;
    }

    @FXML
    TextField programNameInput;
    // A list of all current programmes
    ArrayList<Program> newProgrammesList;

    @FXML //added so that .fxml file can assign this method to an element.
    // When "Create Programme" button gets pressed:
    private void triggerNewProgramme() {
        newProgrammesList = main.getProgramsList();
        String programName = programNameInput.getText();

        if (programName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid programme name.");
            alert.showAndWait(); // Show alert screen and block execution until closed.
            return;
        }

        // Check if the programme name already exists
        for (Program program : newProgrammesList) {
            if (program.toString().equals(programName)) {
                // if the "new" programme name already exists, change the text prompt and clear the input.
                programNameInput.clear();
                programNameInput.setPromptText("Duplicate programme name! Please choose another name.");
                return;
            }
        }

        // if no duplicates is found, create the new programme.
        main.newProgramme(programName);

        // update the list of programmes since a new one was created above.
        newProgrammesList = main.getProgramsList();

        // Update combobox values
        feedProgrammesOptions();
    }



    @FXML
    ComboBox<Program> programmesOptions;

    public void feedProgrammesOptions() {

        ObservableList<Program> observableProgrammesOptions = FXCollections.observableArrayList(newProgrammesList);
        programmesOptions.setItems(observableProgrammesOptions);

        // Sets the default selection using obeservablelist.
        if (!observableProgrammesOptions.isEmpty()) {
            programmesOptions.setValue(observableProgrammesOptions.get(0));
        }
    }


    @FXML
    TextField studentNameInput;

    @FXML
    private void triggerNewStudent() {
        //main.newStudent(studentNameInput.getText(), programmesOptions.getValue());

        String studentName = studentNameInput.getText();
        Program programName = programmesOptions.getValue();

        // Error given when User doesn't input name or programme.
        if (studentName.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid student name.");
            alert.showAndWait();
            return;
        } else if (programmesOptions.getValue().toString().isEmpty() || programmesOptions.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select a valid programme.");
            alert.showAndWait();
            return;
        }
        main.newStudent(studentName, programName);


    }

}
