package org.polar.swedishmeritscorecalculator;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private int points;
    private List<Program> programs;

    public Course(String name, int points) {
        this.name = name;
        this.points = points;
        this.programs = new ArrayList<>();
    }

    public void addProgram(Program program) {
        if (!programs.contains(program)) {
            programs.add(program);
            program.addCourse(this);
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void displayPrograms() {
        System.out.println("Course: " + name + " is in programs:");
        for (Program program : programs) {
            System.out.println("  - " + program.toString());
        }
    }

    @Override
    public String toString() {
        return name + " (" + points + "p)";
    }
}