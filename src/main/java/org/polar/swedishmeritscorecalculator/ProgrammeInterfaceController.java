package org.polar.swedishmeritscorecalculator;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ProgrammeInterfaceController {
    private HighSchoolSystem main;

    @FXML
    private ComboBox<Program> programmesOptions;
    @FXML
    private ComboBox<Integer> pointsBox;
    @FXML
    private TextField courseName;
    @FXML
    private TextField listOfProgrammes; // For displaying course programs

    public void setMainApp(HighSchoolSystem mainApp) {
        this.main = mainApp;
        feedProgrammesOptions();
    }

    @FXML
    private void switchToCreationMenu() {
        SceneManager.changeScene("Creation_Interface.fxml");
        System.out.println("Creation_Interface.fxml");
    }

    private void feedProgrammesOptions() {
        ArrayList<Program> newProgrammesList = main.getProgramsList();
        programmesOptions.getItems().setAll(newProgrammesList);
        if (!newProgrammesList.isEmpty()) {
            programmesOptions.setValue(newProgrammesList.get(0));
        }

        ArrayList<Integer> points = new ArrayList<>();
        points.add(50);
        points.add(100);
        points.add(150);
        points.add(200);
        pointsBox.getItems().setAll(points);
    }

    @FXML
    private void triggerNewCourse() {
        Program selectedProgramme = programmesOptions.getValue();
        if (selectedProgramme == null || courseName.getText().isEmpty() || pointsBox.getValue() == null) {
            System.out.println("Invalid input");
            return;
        }
        main.newCourse(selectedProgramme, courseName.getText(), pointsBox.getValue());
        System.out.println("New Course created: " + courseName.getText());
    }

    @FXML
    private void displayProgramCourses() {
        Program selectedProgramme = programmesOptions.getValue();
        if (selectedProgramme != null && listOfProgrammes != null) {
            String result = "Courses for " + selectedProgramme.toString() + ":\n";
            for (Course course : selectedProgramme.getCourses()) {
                result = result + course.getName() + "\n";
            }
            listOfProgrammes.setText(result);
        } else {
            System.err.println("Error: selectedProgramme or listOfProgrammes is null");
        }
    }
}