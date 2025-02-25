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
