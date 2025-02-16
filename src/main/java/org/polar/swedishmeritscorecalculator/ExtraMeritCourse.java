package org.polar.swedishmeritscorecalculator;

public class ExtraMeritCourse extends Course {
    private char grade;
    ExtraMeritCourse(String name, int points, char grade) {
        super(name, points, grade);
    }

    @Override
    public double getGradeValue() {
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
