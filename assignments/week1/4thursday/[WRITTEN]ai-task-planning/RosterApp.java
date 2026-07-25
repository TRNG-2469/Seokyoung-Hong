package com.revature.ai;

//Step 3: Implement RosterApp, checking and populating our classes
public class RosterApp {


    public static void main(String[] args) {
        Course course = new Course(10);
        Student seoky = new Student("Seoky", 2.5);
        Student lucky = new Student("Lucky", 5.0);
        Student sad = new Student("Sad", 1.0);

        course.addStudent(seoky);
        course.addStudent(lucky);
        course.addStudent(sad);

        System.out.println(course.calculateAverage());
    }

}
