package org.polar.swedishmeritscorecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class HighSchoolSystem extends Application {
    private Scanner sc;
    private Program program;
    private InterfaceController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Interface.fxml"));

        Parent root = loader.load();

        controller = loader.getController();
        controller.setMain(this); // Pass main reference to controller
        controller.setRoot(root); // Set the root node in the controller

        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


        //sc.close();

    }

    public HighSchoolSystem() {
        program = new Program("PROGRAMnumbahONE");
    }

    public void newCourse(String courseName, int coursePoints, char courseGrade) {

        program.addCourse(new ProgramSpecificCourse(courseName, coursePoints, courseGrade));

        program.getTotalMerit();
    }

    public void removeCourse(String courseName) {
        // note to self. this does in fact remove the course from the courses list in program.
        program.removeCourse(courseName);
    }



    private void newProgram() {
        System.out.println("Enter new program");
        //String programName =

        /*program.addCourse(new ProgramSpecificCourse("Physics 1", 100));
        program.addCourse(new ProgramSpecificCourse("Physics 2", 200));
        program.addCourse(new ProgramSpecificCourse("Physics 3", 300));

        program.displayCourses();
        System.out.println("\n");

        program.removeCourse("Physics 1");
        program.removeCourse("Physics 2");

        //program.addCourse(new ExtraMeritCourse("Math 4", 1));

        program.displayCourses();
        program.getTotalPoints();

        program.getTotalMerit();
*/
    }

    private void addCourse() {

    }

    private void displayMerit() {
    }


    public static void main(String[] args) {
        launch();
    }
}