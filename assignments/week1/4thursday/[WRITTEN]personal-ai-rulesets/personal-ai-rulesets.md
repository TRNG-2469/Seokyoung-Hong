Going forward, I will adhere to the following three rules in utilizing AI:
1) 10-Minute Timer: Attempt to debug manually at first 
2) No blind ghost completions 
3) Simplicity Constraints: Ban advanced, unstudied APIs 

# Prompt Log 

## 1) First Attempt 
- **Context**: Building utilities class for array manipulation. Have implemented 
```
// Developer's Manual Attempt:
public static int[] removeDuplicates(int[] arr) {
    int[] temp = new int[arr.length];
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        boolean isDup = false;
        for (int j = 0; j < count; j++) {
            if (arr[i] == temp[j]) {
                isDup = true;
                break;
            }
        }
        if (!isDup) {
            temp[count] = arr[i];
            count++;
        }
    }
    return temp; // Logic flaw: temp array size matches original, padded with trailing zeros!
}
``` 
previously. 
- **Prompt**: I am practicing array manipulation. I wrote this method to remove duplicates as shown above.
It works, but it returns trailing zeros because the output array is not resized to 'count'. 
- How do I copy elements to a new array of size 'count' using standard array indexing?
- **AI Response**:
```
- // Verified, Safe Final Code:
  public class ArrayUtilities {

  /**
    * Removes duplicate values from an array without using external collection classes.
    * Demonstrates manual array copying for resizing.
      */
      public static int[] removeDuplicates(int[] arr) {
          if (arr == null || arr.length == 0) {
            return new int[0];
          }
    
          int[] temp = new int[arr.length];
          int uniqueCount = 0;
    
          for (int i = 0; i < arr.length; i++) {
            boolean isDuplicate = false;
              for (int j = 0; j < uniqueCount; j++) {
                  if (arr[i] == temp[j]) {
                  isDuplicate = true;
                break;
                }
              }
              if (!isDuplicate) {
                temp[uniqueCount] = arr[i];
                uniqueCount++;
              }
          }

          // Resizing using standard array replication:
          int[] result = new int[uniqueCount];
          for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i]; // Copy only unique values
          }
          return result;
      }
  public static void main(String[] args) {
      int[] scores = {10, 20, 20, 30, 10};
      int[] uniqueScores = removeDuplicates(scores);
      System.out.println("Cleaned array: " + java.util.Arrays.toString(uniqueScores)); // [10, 20, 30]
      }
  }
 ```

## 2) Evaluation 
Instead of blind acceptance of the removeDuplicates code, the developer tried their own hand and 
refined their prompt with AI. The AI's response robustly resizes the array to match the new size
after duplicates are removed, and is production-tier quality. 