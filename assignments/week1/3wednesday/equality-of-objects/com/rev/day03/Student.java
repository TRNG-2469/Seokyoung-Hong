package com.rev.day03;

public class Student {
    private String name;
    private int age;
    private String course;
    private static int studentCount = 0;

    public Student(){
        studentCount++;
    }

    public Student(String name, int age, String course) {
        studentCount++;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    public static int getStudentCount() {
        return studentCount;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Student compareObj = (Student) obj;
        return  compareObj.age == this.age &&
                compareObj.name.equals(this.name) &&
                compareObj.course.equals(this.course);
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age + course.hashCode();
    }
}