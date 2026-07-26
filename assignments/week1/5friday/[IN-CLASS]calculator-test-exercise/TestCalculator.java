package com.rev.demo;

import org.junit.jupiter.api.*;

public class TestCalculator {

    Calculator calculator = null;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    // ==================== ADD ====================

    @Test
    void testPositiveAdd() {
        // Arrange
        int a = 10;
        int b = 15;
        int expectedResult = 25;

        // Act
        int actualResult = calculator.add(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNegativeAdd() {
        // Arrange
        int a = -10;
        int b = -15;
        int expectedResult = -25;

        // Act
        int actualResult = calculator.add(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeAddZero() {
        // Arrange
        int a = 0;
        int b = 15;
        int expectedResult = 15;

        // Act
        int actualResult = calculator.add(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeAddOverflow() {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 1;
        int expectedResult = Integer.MIN_VALUE;

        // Act
        int actualResult = calculator.add(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    // ==================== SUBTRACT ====================

    @Test
    void testPositiveSubtract() {
        // Arrange
        int a = 20;
        int b = 5;
        int expectedResult = 15;

        // Act
        int actualResult = calculator.subtract(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNegativeSubtract() {
        // Arrange
        int a = -20;
        int b = -5;
        int expectedResult = -15;

        // Act
        int actualResult = calculator.subtract(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeSubtractZero() {
        // Arrange
        int a = 15;
        int b = 0;
        int expectedResult = 15;

        // Act
        int actualResult = calculator.subtract(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeSubtractUnderflow() {
        // Arrange
        int a = Integer.MIN_VALUE;
        int b = 1;
        int expectedResult = Integer.MAX_VALUE;

        // Act
        int actualResult = calculator.subtract(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    // ==================== MULTIPLY ====================

    @Test
    void testPositiveMultiply() {
        // Arrange
        int a = 6;
        int b = 5;
        int expectedResult = 30;

        // Act
        int actualResult = calculator.multiply(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNegativeMultiply() {
        // Arrange
        int a = -6;
        int b = 5;
        int expectedResult = -30;

        // Act
        int actualResult = calculator.multiply(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeMultiplyZero() {
        // Arrange
        int a = 0;
        int b = 25;
        int expectedResult = 0;

        // Act
        int actualResult = calculator.multiply(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeMultiplyOverflow() {
        // Arrange
        int a = Integer.MAX_VALUE;
        int b = 2;
        int expectedResult = -2;

        // Act
        int actualResult = calculator.multiply(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    // ==================== DIVIDE ====================

    @Test
    void testPositiveDivide() {
        // Arrange
        int a = 20;
        int b = 5;
        double expectedResult = 4;

        // Act
        double actualResult = calculator.divide(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNegativeDivide() {
        // Arrange
        int a = -20;
        int b = 5;
        double expectedResult = -4;

        // Act
        double actualResult = calculator.divide(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeDivideZeroDividend() {
        // Arrange
        int a = 0;
        int b = 5;
        double expectedResult = 0;

        // Act
        double actualResult = calculator.divide(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeDivideOverflow() {
        // Arrange
        int a = Integer.MIN_VALUE;
        int b = -1;
        double expectedResult = 2147483648.0;

        // Act
        double actualResult = calculator.divide(a, b);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeDivideByZero() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act and Assert
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(a, b)
        );
    }

    // ==================== SQUARE ====================

    @Test
    void testPositiveSquare() {
        // Arrange
        int number = 7;
        int expectedResult = 49;

        // Act
        int actualResult = calculator.square(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNegativeSquare() {
        // Arrange
        int number = -7;
        int expectedResult = 49;

        // Act
        int actualResult = calculator.square(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeSquareZero() {
        // Arrange
        int number = 0;
        int expectedResult = 0;

        // Act
        int actualResult = calculator.square(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeSquareOverflow() {
        // Arrange
        int number = 50_000;
        int expectedResult = -1_794_967_296;

        // Act
        int actualResult = calculator.square(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    // ==================== INVERT ====================

    @Test
    void testPositiveInvert() {
        // Arrange
        int number = 12;
        int expectedResult = -12;

        // Act
        int actualResult = calculator.invert(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testNegativeInvert() {
        // Arrange
        int number = -12;
        int expectedResult = 12;

        // Act
        int actualResult = calculator.invert(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeInvertZero() {
        // Arrange
        int number = 0;
        int expectedResult = 0;

        // Act
        int actualResult = calculator.invert(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testEdgeInvertMinValue() {
        // Arrange
        int number = Integer.MIN_VALUE;
        int expectedResult = Integer.MIN_VALUE;

        // Act
        int actualResult = calculator.invert(number);

        // Assert
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
