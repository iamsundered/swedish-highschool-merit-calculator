package org.polar.swedishmeritscorecalculator;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private Program program;
    private Map<Course, Character> courseGrades;

    public Student(String name, Program program) {
        this.name = name;
        this.program = program;
        this.courseGrades = new HashMap<>();
    }

    public void setGrade(Course course, char grade) {
        courseGrades.put(course, Character.toUpperCase(grade));
    }

    public double calculateMeritScore() {
        double totalMerit = 0;
        int totalPoints = 0;
        for (Course course : program.getCourses()) {
            Character grade = courseGrades.get(course);
            if (grade != null) {
                double gradeValue = switch (grade) {
                    case 'A' -> 20.0;
                    case 'B' -> 17.5;
                    case 'C' -> 15.0;
                    case 'D' -> 12.5;
                    case 'E' -> 10.0;
                    case 'F' -> 0.0;
                    default -> 0.0;
                };
                totalMerit += gradeValue * course.getPoints();
                totalPoints += course.getPoints();
            }
        }
        // In the Swedish system, merit is often the total grade points; adjust if averaging is needed
        return totalMerit;
    }

    public String getStudentName() {
        return name;
    }

    public String getProgramName() {
        return program.toString();
    }

    public Program getProgram() {
        return program;
    }

    public Map<Course, Character> getCourseGrades() {
        return courseGrades;
    }
}