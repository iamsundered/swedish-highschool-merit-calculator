package org.polar.swedishmeritscorecalculator;

public class Student {
    private String name;
    private Program program;

    Student(String name, Program program) {
        this.name = name;
        this.program = program;
    }

    public String getStudentName() {
        return name;
    }
    public Program getProgramName() {
        return program;
    }
}
