package com.revature.ai;

//Step 2: Implement Course according to plan
public class Course {
    private Student[] students;
    private int studentCount;

    public Course(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(
                    "Capacity must be greater than zero."
            );
        }

        students = new Student[capacity];
        studentCount = 0;
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException(
                    "Student cannot be null."
            );
        }

        if (studentCount >= students.length) {
            throw new IllegalStateException(
                    "Course is full."
            );
        }

        students[studentCount] = student;
        studentCount++;
    }

    public double calculateAverage() {
        if (studentCount == 0) {
            return 0.0;
        }

        double total = 0.0;

        for (int i = 0; i < studentCount; i++) {
            total += students[i].getScore();
        }

        return total / studentCount;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public int getCapacity() {
        return students.length;
    }
}