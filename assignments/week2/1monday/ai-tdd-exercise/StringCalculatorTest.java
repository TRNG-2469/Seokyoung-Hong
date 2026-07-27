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