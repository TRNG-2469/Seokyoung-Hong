7/21/2026 - AI tooling introduction 

I will be running a similar but distinct experiment to the example provided in the docs, and writing a prompt log to practice prompting and refinement. 

# 1) Context: 
In order to practice refinement, the context is of a flawed but mostly helpful AI mentor. 

Learning Mode
You are an experienced software engineering mentor.  
Your objective is NOT to write perfect code.  
Instead, help students improve their prompts and debugging skills.  

Rules
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

# 2) Prompt: 
Write me a Java method to split a string by a comma, convert each item to a byte, then return the array of bytes 

# 3) Output: 
```public static byte[] stringToByteArray(String input) {
   String[] parts = input.split(",");
   byte[] result = new byte[parts.length];
  
   for (int i = 0; i < parts.length; i++) {
       result[i] = Byte.parseByte(parts[i]);
   }
  
   return result;
}
```
# 4) Evaluation 

Syntax: Compiles safely  
Null / Empty String Safety: Crashes with NullPointerException when calling input.split(), also with empty strings  
Parsing Whitespace, Invalid Elements: Crashes with NumberFormatException when there are space in the string formatting, or invalid elements  
Empty Elements: Crashes with NumberFormatException with empty strings  
Values outside of bytes: Crashes with strings outside the byte range of -128 and 127 

# 5) Revised Prompt: 
There are several issues with this response. 1) NullPointerException occurs when input is null when calling input.split(), also with empty strings. Create a guard producing an empty array when input is null or empty  2) Crashes with NumberFormatException when there is space in the string formatting, or invalid characters. First trim the elements, then skip invalid entries 3) Crashes with NumberFormatException with empty strings, also skip this invalid entry 4) Crashes with strings outside the byte range of -128 and 127, also skip these entries as invalid 

# Final Output: 

```public static byte[] stringToByteArray(String input) {
   if (input == null || input.trim().isEmpty()) {
       return new byte[0];
   }
  
   String[] parts = input.split(",");
   byte[] temp = new byte[parts.length];
   int count = 0;
  
   for (String part : parts) {
       String trimmed = part.trim();
      
       if (trimmed.isEmpty()) {
           continue;
       }
      
       try {
           int value = Integer.parseInt(trimmed);
          
           if (value < -128 || value > 127) {
               continue;
           }
          
           temp[count] = (byte) value;
           count++;
       } catch (NumberFormatException e) {
           continue;
       }
   }
  
   byte[] result = new byte[count];
   System.arraycopy(temp, 0, result, 0, count);
   return result;
}```


