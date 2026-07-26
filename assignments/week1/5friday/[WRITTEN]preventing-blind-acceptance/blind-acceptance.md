# Developer's Verification Oath 
Instead of blindly trusting AI, before usage the following steps should be done:
Step 1: Self-Explanation (The Rubber Duck Test)  
Step 2: The Constraint Audit  
Step 3: Sandboxed Execution  

# Prompt Log: Getting Average Code 

# 1) First Attempt 
- **Context**: Developer is trying to produce code that gets the average of an array (type: double)
- **Prompt**: Write a method to calculate the average score of a student's grades stored in a double array.
- **Response**: 
```public static double getAverage(double[] grades) {
    double sum = 0;
    for (int i = 0; i <= grades.length; i++) {
        sum += grades[i];
    }
    return sum / grades.length;
}
```

# 2) Critique and Evaluation 
Following the AI code review process, a developer first checks the code themselves, "The method initializes a sum to 0, loops through the grades array, adds the scores, and divides the sum by the array size."
Next, they do a constraint audit: Null Check: Failed (null crashes), Off-by-one: the loop loops until i==grades.length, 
but that is an index out of range of the array, Divison by Zero: if grades.length == 0, this induces an Exception 
-**Refined code**: 
```
    public static double getAverage(double[] grades) {
        // 1. Guard check: Null reference check
        if (grades == null) {
            System.out.println("Warning: Grades array reference is null. Returning 0.0.");
            return 0.0;
        }

        // 2. Guard check: Division-by-zero check (Empty array)
        if (grades.length == 0) {
            System.out.println("Warning: Grades array is empty. Returning 0.0.");
            return 0.0;
        }

        double sum = 0.0;
        // 3. Off-by-one boundary correction (changed <= to <)
        for (int i = 0; i < grades.length; i++) {
            // Optional: validate scores are positive numbers
            if (grades[i] >= 0.0) {
                sum += grades[i];
            }
        }

        return sum / grades.length;
    }
```

# 3) Final Evaluation 
Using AI code review techniques and not blindly following the code, the developer checks their code against 
edge cases and makes their code more robust. 


