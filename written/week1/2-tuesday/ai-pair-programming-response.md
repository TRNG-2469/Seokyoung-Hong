7/21/2026 - AI pair programming 

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
Write me a Java method named getFinalChar that takes a String name and returns the last character of each word 

3) Output 
public static String getFinalChar(String name) {
   String[] words = name.split(" ");
   String result = "";
  
   for (String word : words) {
       result += word.charAt(word.length() - 1);
   }
  
   return result;
}

4) Evaluation: 

Syntax: Compiles safely 
Null: Crashes with exception when the argument is null, when doing name.split() 
Bounds: When there are multiple spaces or empty strings, the split can produce empty strings and cause a crash of StringIndexOutOfBoundsException when accessing word.charAt(-1). 


5) Revised Prompt: 

The getFinalChar method has several issues: 1) It crashes with NullPointerException if the input name is null when attempting to do name.split(). Produce a guard check at the beginning to handle nulls, returning an empty string. 2) When encountering words with multiple spaces or input as an empty string, split produces empty strings, meaning word.charAt() crashes. So, before processing, provide a check that if it’s an empty string, return empty string, or otherwise trim extra spaces.

Final Output: 

public static String getFinalChar(String name) {
   if (name == null || name.trim().isEmpty()) {
       return "";
   }
  
   String[] words = name.trim().split("\\s+");
   String result = "";
  
   for (String word : words) {
       if (!word.isEmpty()) {
           result += word.charAt(word.length() - 1);
       }
   }
  
   return result;
