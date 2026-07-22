## Code Differences

The AI's code is shorter because it has access to String functions and pre-built classes designed 
for efficiency. These functionalities are common occurrences for developers so there's already resources
from other packages whose methods can be used. However, for learning purposes, manually implementing the
string manipulation functions are a good exercise for iteration, using only built-in functionality to 
understand how they work in the low level. 

## Edge Case Evaluations 
Both implementations handle edge cases without failing. Both implementation use null guards to hard-code 
a return value for null inputs, or handle empty strings due to the nature of string iteration stopping 
at the end of the string, or built-in functions that handle empty strings. 