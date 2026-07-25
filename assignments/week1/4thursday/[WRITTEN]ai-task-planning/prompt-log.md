# Prompt) Task planning Student and Course 

## 1) First Attempt 
- **Prompt**: I need to build the following system:   
- Build a student roster system. Define a Student class (name, score). 
- Define a Course class containing an array of Students, a method to add students, 
- and a method to calculate course averages.   
- Break this project down into a step-by-step, file-by-file implementation plan.

- **Generated Response**: 
- File 1: Student.java
Step 1: Create the class: Create a class named Student.  
Step 2: Add instance variables. The class needs two private fields:
```private String name; 
private double score;
```
name stores the student’s name.  
score stores the student’s grade or score.  
Step 3: Add a constructor. Create a constructor that receives a name and score and assigns them to the fields.
```
public Student(String name, double score) {
this.name = name;
this.score = score;
}
```
Step 4: Add getter methods
The Course class will need access to each student’s information, especially the score.  
```
public String getName() {
return name;
}
public double getScore() {
return score;
}
```

- File2: Course.java 
- File 2: Course.java
Step 1: Create the class  
Create a class named Course.
Step 2: Add a Student array. The course must contain an array that stores Student objects.
```
- private Student[] students;
```
Step 3: Track how many students were added. An array may contain unused positions with a value of null. 
Add a counter so the program knows how many positions are actually occupied.  
```
private int studentCount;
```
For example, an array may have a capacity of five but currently contain only two students: [Alice, Bob, null, null, null]
In that case, studentCount should be 2.

Step 4: Add a constructor. The constructor should receive the maximum number of students the course can hold.
```
public Course(int capacity) {
students = new Student[capacity];
studentCount = 0;
}
```
Step 5: Implement addStudent

This method should:

Receive a Student object.  
Check whether the array is full.  
Store the student at the next available index.  
Increase studentCount.  
```
public void addStudent(Student student) {
if (studentCount >= students.length) {
System.out.println("Course is full.");
return;
}
    students[studentCount] = student;
    studentCount++;
}
```
The first student is stored at index 0, the second at index 1, and so on.

Step 6: Implement calculateAverage

This method should:

Return 0 when no students have been added.  
Loop only through the occupied array positions.  
Add each student’s score.  
Divide the total by studentCount.  
```
public double calculateAverage() {
if (studentCount == 0) {
return 0;
}
    double total = 0;

    for (int i = 0; i < studentCount; i++) {
        total += students[i].getScore();
    }

    return total / studentCount;
}
```
Looping only until studentCount prevents the program from trying to call getScore() on unused null positions.


## 2) Evaluation: 
-**Student.java**: There are a lack of boundary checks for the Student fields, for null or empty values.
-**Course.java**: The provided code implements boundary checks to prevent edge cases (ex. negative score).
The model seems to be well-structured and meets the requirements of the prompt. The Student class encapsulates the necessary attributes and provides access through getter methods. The Course class effectively manages an array of Student objects, allowing for adding students and calculating the average score. 
The implementation plan is clear and provides a step-by-step guide for building the system.

## 3) Refinement: 
-**Refined Prompt**: Give me the planning requirements for the Student.java again, but note boundary checks 
in the student fields to cover null or edge cases. 
-**Refined Plan (Refined snippets only shown)**:
Step 4: Validate the student's name. Before assigning the name, ensure it is valid.

The constructor should check:  
The name is not null.  
The name is not empty or only whitespace.  

If either condition fails, throw an IllegalArgumentException.

Example validation logic:
```
if (name == null || name.trim().isEmpty()) {
    throw new IllegalArgumentException("Name cannot be null or empty.");
}
```

If valid, remove any leading or trailing spaces before storing it.
```
this.name = name.trim();
```

Step 5: Validate the student's score

Before storing the score, verify that it is a valid value.

Check that:

The score is not NaN (Double.isNaN(score)).
The score is not positive or negative infinity (Double.isInfinite(score)).
The score is within the allowed range (for example, 0–100).

Example validation:
```
if (Double.isNaN(score) || Double.isInfinite(score)) {
throw new IllegalArgumentException("Score must be a valid number.");
}

if (score < 0 || score > 100) {
throw new IllegalArgumentException("Score must be between 0 and 100.");
}
```

If all validations pass, assign the score.

## 4) Final Evaluation:
The refined plan now includes necessary boundary checks for the Student class, 
ensuring that the name and score are covered with exceptions and are never 
null or invalid. This will help prevent potential runtime errors and maintain data integrity within the system. The Course class remains unchanged, as it already handles edge cases effectively. 
Overall, the implementation plan is robust and ready for development.
