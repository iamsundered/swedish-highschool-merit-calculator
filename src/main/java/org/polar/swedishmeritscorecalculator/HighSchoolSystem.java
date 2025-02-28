package org.polar.swedishmeritscorecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HighSchoolSystem extends Application {
    private Scanner sc;
    private Program program;
    ArrayList<Program> programsList = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.setMainApp(this);
        SceneManager.changeScene("Creation_Interface.fxml");
    }


    public void newProgramme(String programName) {
        System.out.println("Enter new program");
        this.program = new Program(programName);

        programsList.add(program);
        program.displayProgramName();

    }

    public ArrayList<Program> getProgramsList() {
        return programsList;
    }

    public void newStudent(String studentName, Program programme) {
        Student student = new Student(studentName, programme);

        System.out.println("\nnew student: ");
        System.out.println("Name: "+student.getStudentName());
        System.out.println("Programme: "+student.getProgramName() +"\n");

    }


    public void newCourse(String courseName, int coursePoints, char courseGrade) {

        program.addCourse(new ProgramSpecificCourse(courseName, coursePoints, courseGrade));

        program.getTotalMerit();
    }

    public void removeCourse(String courseName) {
        // note to self. this does in fact remove the course from the courses list in program.
        program.removeCourse(courseName);
    }



    private void addCourse() {

    }

    private void displayMerit() {
    }


    public static void main(String[] args) {
        launch();
    }
}