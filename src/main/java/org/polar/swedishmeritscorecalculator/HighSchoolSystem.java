package org.polar.swedishmeritscorecalculator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HighSchoolSystem extends Application {
    private ArrayList<Program> programsList = new ArrayList<>();
    private ArrayList<Student> studentsList = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        SceneManager.setStage(stage);
        SceneManager.setMainApp(this);
        SceneManager.changeScene("Creation_Interface.fxml");
    }

    public void newProgramme(String programName) {
        Program program = new Program(programName);
        programsList.add(program);
        program.displayProgramName();
    }

    public ArrayList<Program> getProgramsList() {
        return programsList;
    }

    public void newStudent(String studentName, Program programme) {
        Student student = new Student(studentName, programme);
        studentsList.add(student);
        System.out.println("\nNew student: ");
        System.out.println("Name: " + student.getStudentName());
        System.out.println("Programme: " + student.getProgramName() + "\n");
    }

    public void newCourse(Program selectedProgramme, String courseName, int coursePoints) {
        if (selectedProgramme == null) {
            System.out.println("No programme selected");
            return;
        }
        Course course = new Course(courseName, coursePoints);
        selectedProgramme.addCourse(course);
        course.displayPrograms();
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public static void main(String[] args) {
        launch();
    }
}