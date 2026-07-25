package com.rev.day03;

public class StudentManager {
    public static void main(String[] args) {

        //Step 1: Create objects to test equality on
        Student s1 = new Student("Seoky", 24, "CoolCourse");
        System.out.println(Student.getStudentCount());
        Student s2 = new Student("Seoky", 24, "CoolCourse");
        Student s3 = new Student("RandomPerson", 100, "CoolCourse");
        System.out.println(Student.getStudentCount());

        //Step 2: Test printing, equality
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("s1 is same as s2 is " + (s1.equals(s2)));
        System.out.println("s2 is same as s3 is " + (s2.equals(s3)));

    }
}