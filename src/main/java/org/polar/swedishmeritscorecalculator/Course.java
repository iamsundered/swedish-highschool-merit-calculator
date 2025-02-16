package org.polar.swedishmeritscorecalculator;

abstract class Course {
    protected String name;
    protected int points;
    protected char grade;

    Course(String name, int points, char grade) {
        this.name = name;
        this.points = points;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return getName() + " (" + getPoints() + "p) - Grade points: " + getGrade();
    }

    abstract double getGradeValue();


}
