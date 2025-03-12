package org.polar.swedishmeritscorecalculator;

import java.util.ArrayList;

public class Program {
    private String name;
    private ArrayList<Course> courses;

    public Program(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addProgram(this);
        }
    }

    public void removeCourse(String courseName) {
        courses.removeIf(course -> course.getName().equals(courseName));
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void displayCourses() {
        System.out.println("Program: " + name);
        for (Course course : courses) {
            System.out.println("  - " + course.getName());
        }
    }

    public void displayProgramName() {
        System.out.println(name);
    }
}