package com.revature.ai;

// Step 2: Implement Student classes according to plan
public class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Name cannot be null or empty."
            );
        }

        if (Double.isNaN(score) || Double.isInfinite(score)) {
            throw new IllegalArgumentException(
                    "Score must be a valid number."
            );
        }

        if (score < 0 || score > 100) {
            throw new IllegalArgumentException(
                    "Score must be between 0 and 100."
            );
        }

        this.name = name.trim();
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}