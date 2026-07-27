# Prompt Log - AI TDD Evaluation 

# 1) First attempt 
- **Context**: Implemented StringCalculator class and I need to test it for edge-case scenarios 
- **Prompt**: Act as a Senior Quality Assurance Engineer. Review the following Java utility requirements: 
A StringCalculator class has three methods: add(String), multiply(String), and divide(String). 
Each method parses a comma-separated string of integer numbers. 
Generate a JUnit 5 test class covering at least 5 complex edge cases for these methods 
(e.g. empty strings, null inputs, negative values, trailing commas, spaces, or division boundaries). 
Return ONLY the JUnit 5 Java code block. Do not write any conversational text or explanations.
- **Response**: 
```java
package ai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void multiplyShouldHandleNegativeValuesZeroAndSpaces() {
        assertAll(
                () -> assertEquals(-24, calculator.multiply(" -2, 3, 4 ")),
                () -> assertEquals(0, calculator.multiply("5, 0, -10"))
        );
    }

    @Test
    void methodsShouldRejectMissingNumberBetweenCommas() {
        assertAll(
                () -> assertThrows(NumberFormatException.class,
                        () -> calculator.add("1,,2")),
                () -> assertThrows(NumberFormatException.class,
                        () -> calculator.multiply("2,,3")),
                () -> assertThrows(NumberFormatException.class,
                        () -> calculator.divide("10,,2"))
        );
    }

    @Test
    void addShouldThrowExceptionForLeadingComma() {
        assertThrows(NumberFormatException.class,
                () -> calculator.add(",1,2"));
    }

    @Test
    void addShouldThrowExceptionForAlphabeticInput() {
        assertThrows(NumberFormatException.class,
                () -> calculator.add("1,a,3"));
    }

    @Test
    void addShouldRejectIntegerOverflow() {
        assertThrows(ArithmeticException.class,
                () -> calculator.add("2147483647,1"));
    }

    @Test
    void addShouldRejectTrailingComma() {
        assertThrows(NumberFormatException.class,
                () -> calculator.add("1,2,"));
    }

}
```
# 2) Audit, Evaluation 
-**Compilation Check**: The tests appear to be written in standard JUnit5 notation and correctly
writes Assertions, including lambdas with AssertThrows 
-**Logical Veracity**: The test cases mostly all fall in line with the class specifications and 
constraints. However, one difference in that the AI suggests tests that induce empty 
strings not covered by split() (leading commas, letters in input) should throw a NumberFormatException. This is valid in how the 
code is formatted, but something to consider in the specifications. I marked these tests as valid 
to support this behavior, because it seems like a reasonable way to handle erroneous commas. 
The test cases in which the class fails to cover that the AI points out is extremely large numbers inducing overflow and 
trailing commas, which should induce NumberFormatException. 
-**Redundancy**: Every test case suggested covers a different field, even if the input is slightly different 
to induce more bug-checking. Nothing is completely identical. 

# 3) Document, Remediate 
| Test Case Suggested                                | Intent/Edge Case Covered         | Evaluation (Valid / Invalid / Redundant) | Action Required                                                     |
|----------------------------------------------------|----------------------------------|-------------------------------------------|---------------------------------------------------------------------|
| `multiplyShouldHandleNegativeValuesZeroAndSpaces()` | Spaces in input, existence of 0  | Valid. | Already handled - trims, * handles 0.                               |
| `methodsShouldRejectMissingNumberBetweenCommas()`  | Erroneous commas between numbers | Valid. | Already handled - split() throws NumberFormatException              |
| `addShouldThrowExceptionForLeadingComma()` | Leading commas existence         | Valid. | Already handled - split() throws NumberFormatException              |
| `addShouldThrowExceptionForAlphabeticInput()`  | Non-numerical input              | Valid. | Already handled - Integer.parseInt() throws NumberFormatException   |
| `addShouldRejectIntegerOverflow()`   | Integer Overflow                 | Valid. | NOT handled - should use Math.exact..() to detect when overflows    |
| `addShouldRejectTrailingComma()` | Trailing commas                  | Valid. | NOT handled - should use split with parameter -1 to throw Exception |

StringCalculator.java was updated with the new implementation handled the latter two cases. 

# 4) Evaluation 
Reading the AI suggestions, documenting them against the project specifications before implementing 
changes was useful for understanding edge cases that needed to be handled in the calculator. The project
is now more robust.


