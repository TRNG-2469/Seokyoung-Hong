# AI Prompt Log: Palindrome Checker 

## 1. Initial Attempt 
- **Context**: 
In order to emulate AI mistakes to practice prompt engineering, I provided the following context along with the context of solving a palindrome question. 

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
This is the palindrome validation algorithm. 

- **Prompt**: Write a Java method to check if a string is a palindrome
- **Generated Code**: 
```
public static boolean isPalindrome(String str) {
   if (str == null) {
       return false;
   }
  
   if (str.isEmpty()) {
       return true;
   }
  
   String cleaned = str.toLowerCase();
  
   int left = 0;
   int right = cleaned.length() - 1;
  
   while (left < right) {
       if (cleaned.charAt(left) != cleaned.charAt(right)) {
           return false;
       }
       left++;
       right--;
   }
  
   return true;
}
```

## 2: Critique & Evaluation 
- **Syntax and Compile**: The code successfully compiles and has no errors in syntax 
- **Nullity, Empty String Inputs**: The code correctly returns “True” for null inputs, and “False” for empty strings.
- **Complexity**: The code uses a reasonable two pointer method for determining if a palindrome exists, not resorting to advanced streams  
- **Input Cleaning**: The code does handle casing, but fails to handle whitespaces. If whitespaces are present, it takes the “ “ string into consideration. In addition, it does not skip over punctuation or other non-alphanumeric characters. 

## 3: Refined Attempt 
- **Refined Prompt**: Act as a secure Java compiler. Write me a public static method named isPalindrome that takes in a String and returns a boolean. Constraints: 1. If the input is null, return false. If the input is empty, return true. 2. Remove all non-alphanumeric characters and ignore character casing. 3. Do not use advanced techniques like streams, use simple character iteration." Document with detail on this method on its behavior in Javadoc format
- **Refined Code**: 
```
/**
* Determines if a string is a palindrome, ignoring non-alphanumeric characters and case.
*
* @param str the input string to check
* @return true if the string is a palindrome (or empty after cleaning), false otherwise
*
* Constraints:
* - If input is null, returns false
* - If input is empty, returns true
* - Non-alphanumeric characters are removed before checking
* - Case-insensitive comparison
* - Uses simple character iteration (no streams)
*
* Example:
* - isPalindrome("A man, a plan, a canal: Panama") returns true
* - isPalindrome("race a car") returns false
* - isPalindrome("") returns true
* - isPalindrome(null) returns false
*/
public static boolean isPalindrome(String str) {
   if (str == null) {
       return false;
   }
  
   if (str.isEmpty()) {
       return true;
   }
  
   // Build cleaned string by removing non-alphanumeric characters
   String cleaned = "";
   for (int i = 0; i < str.length(); i++) {
       char c = str.charAt(i);
       if (Character.isLetterOrDigit(c)) {
           cleaned += Character.toLowerCase(c);
       }
   }
  
   if (cleaned.isEmpty()) {
       return true;
   }
  
   // Check if palindrome using two-pointer approach
   int left = 0;
   int right = cleaned.length() - 1;
  
   while (left <= right) {
       if (cleaned.charAt(left) != cleaned.charAt(right)) {
           return false;
       }
       left++;
       right--;
   }
  
   return true;
}
```
## 4: Final Evaluation 
The final code handles nulls, whitespaces and non-alphanumeric characters, and casing. Handling these edge cases makes it more production-ready and more robust. The code is documented so that future developers can grasp the purpose of the function quicker. A slight performance optimization could be to use StringBuilders instead of concatenating the String.
