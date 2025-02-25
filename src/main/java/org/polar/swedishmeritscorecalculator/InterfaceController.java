package org.polar.swedishmeritscorecalculator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.nio.file.Path;
import java.util.ArrayList;

public class InterfaceController {

    // Scene Controll:
    private Parent root;
    private HighSchoolSystem main;

    public void setMain(HighSchoolSystem main) {
        this.main = main;
    }
    public void setRoot(Parent root) {
        this.root = root;
    }

    public void initialize() {
        System.out.println("controller initialized");
        defaultValues();
    }

    public void doNothing() {
        System.out.println("I EXIST IN STRUCTURE MODEL BRANCH!");
    }

    public static final Path jsonFilePath = Path.of("src/main/java/org/polar/swedishmeritscorecalculator/data.json");


    @FXML TextField courseInputTextField; @FXML ComboBox<Integer> pointsComboBox;
    @FXML ComboBox<Character> gradeComboBox; @FXML ComboBox<Integer> extraMeritComboBox;

    // Populating controls with default values.
    public void defaultValues() {

        // Adding points; 50, 100, 150 etc.
        ObservableList<Integer> pointsValues =
                FXCollections.observableArrayList(
                        50, 100, 150, 200
                );
        pointsComboBox.setItems(pointsValues);

        // Adding Grades
        ObservableList<Character> gradeValues =
                FXCollections.observableArrayList(
                        'A', 'B', 'C', 'D', 'E', 'F'
                );
        gradeComboBox.setItems(gradeValues);

    }


    public char getGrade() {
        return gradeComboBox.getSelectionModel().getSelectedItem();
    }
    public int getPoints() {
        return pointsComboBox.getValue();
    }
    public int getExtraMerit() {
        return extraMeritComboBox.getValue();
    }
    public String getCourse() {
        return courseInputTextField.getText();
    }


    public void triggerNewCourse() {
        main.newCourse(getCourse(), getPoints(), getGrade());
    }
    public void triggerRemoveCourse() {
        main.removeCourse(getCourse());
    }

    @FXML
    static TextField summaryTextField;
    public static void displayCoursesText(Course course) {
        System.out.println("name: " + course.getName());
        System.out.println("points: " + course.getPoints());
        System.out.println("grade: " + course.getGrade());
        summaryTextField.setText(summaryTextField.getText()+course.getName());
        // TODO SOMETHING GOOFY UP HERE. TRYING OT DISPLAY IT IN THE TEXTFIELD BUT ITS NOT SHOWING UP FOR SOME REASON.
        //  CHECK OUT Programs displayCourses method.
    }

}