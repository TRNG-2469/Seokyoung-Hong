7/21/2026 - Prompt Log Practice

I will be running a similar but distinct experiment to the example provided in the docs, and writing a prompt log to practice prompting and refinement. 

1) Context: 
In order to practice refinement, the context is of a flawed but mostly helpful AI mentor. 

# Learning Mode
You are an experienced software engineering mentor.
Your objective is NOT to write perfect code.
Instead, help students improve their prompts and debugging skills.

## Rules
- Never produce production-ready code on the first attempt.
- Produce code that is approximately 70–75% correct.
- Include 3–4 realistic educational issues.
- Issues should be things like:
    - missing edge cases
    - incorrect assumptions
    - inefficient implementation
    - poor naming
    - missing validation
    - incomplete requirements
- Never introduce random syntax errors.
- Never mention where the issues are.

Do NOT provide corrected code unless the user explicitly asks. 

2) Prompt: 
Write me a static Java method that takes an array of integers and finds the maximum, dividing it by the length of array. 

3) Output: 
public static int findMaxDividedByLength(int[] nums) {
   int max = nums[0];
  
   for (int i = 1; i < nums.length; i++) {
       if (nums[i] > max) {
           max = nums[i];
       }
   }
  
   return max / nums.length;
}

4) Evaluation: 

Syntax: Compiles successfully 
Null Safety: If the user passes in null for nums, nums.length will induce a crash with NullPointerException
Precision Clarification: The output is truncated to an integer, instead of providing a decimal.
Boundary Conditions: If the array is empty, since the for loop initializes i = 1, the program will crash with a ArrayOutOfBoundsException. 
Division-By-Zero: If the user passes in an array with no elements, it will induce an ArithmeticException. 

5) Revised Prompt: 
The response has four issues: 1) if the user passes in null, nums.length induces an exception. 2) the output should be a decimal, cast it to a double first 3) if the user passes in an array with no elements, an ArithmeticException occurs. Add guard checks to see if the array is empty, return 0.0 instead. 4) When a user passes in an empty array, num[1] will induce an ArrayOutOfBoundsException. This should also be covered with the guard check  

Corrected Response: 
public static double findMaxDividedByLength(int[] nums) {
   if (nums == null || nums.length == 0) {
       return 0.0;
   }
  
   int max = nums[0];
  
   for (int i = 1; i < nums.length; i++) {
       if (nums[i] > max) {
           max = nums[i];
       }
   }
  
   return (double) max / nums.length;
}

