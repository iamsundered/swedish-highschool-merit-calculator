package org.polar.swedishmeritscorecalculator;

import java.util.ArrayList;

public class Program {
    String name;
    ArrayList<Course> courses;

    Program(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        //setupStandardCourses();
    }

    // Instead of showing its memory address when added to combobox as a value,
    // now it returns its name. This, because when displaying an object in a combobox in javafx
    // it automatically calls toString().
    @Override
    public String toString() {
        return name;
    }

    /*public void setupStandardCourses() {
        addCourse(new StandardCourse("english", 100));
        addCourse(new StandardCourse("history", 50));
        addCourse(new StandardCourse("pe", 100));
        addCourse(new StandardCourse("math", 100));
        addCourse(new StandardCourse("natural sciences", 100));
        addCourse(new StandardCourse("religion", 50));
        addCourse(new StandardCourse("civics", 100));
        addCourse(new StandardCourse("swedish", 100));
    }*/
    public void displayProgramName() {
        System.out.println(name);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    public void removeCourse(String courseName) {
        // Checks every Course in courses list if name matches then remove Course.
        courses.removeIf(course -> course.getName().equals(courseName));
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Course course : courses) {
            if (course.getPoints() > 0) {
                totalPoints += course.getPoints();
            }
        }
        return totalPoints;
    }

    public void displayCourses() {
        System.out.println("Program: " + name);
        for (Course course : courses) {
            System.out.println("  - "+course);
            DeprecatedInterfaceController.displayCoursesText(course);
        }
        System.out.println("Total points: " + getTotalPoints());
    }


    public void getTotalMerit() {
        System.out.println(" ");
        System.out.println(" ");

        for (Course course : courses) {
            System.out.println(course.getGradeValue());
            System.out.println(" ");
        }

        System.out.println(" ");
        System.out.println(" ");
    }



}
