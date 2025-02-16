package org.polar.swedishmeritscorecalculator;

public class ProgramSpecificCourse extends Course {
    ProgramSpecificCourse(String name, int points, char grade) {
        super(name, points, grade);
        this.grade = grade;
    }

    @Override
    public double getGradeValue() {
        System.out.println("name: " + getName());
        System.out.println("points: " + points);
        System.out.println("grade: " + grade);
        return switch (grade) {
            case 'A' -> 20 * points;
            case 'B' -> 17.5 * points;
            case 'C' -> 15 * points;
            case 'D' -> 12.5 * points;
            case 'E' -> 10 * points;
            case 'F' -> 0;
            default -> 0;
        };
    }

}
