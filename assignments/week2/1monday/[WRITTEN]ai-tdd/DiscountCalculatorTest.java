package ai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountCalculatorTest {

    private DiscountCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DiscountCalculator();
    }

    // --- Happy Paths ---
    @Test
    public void testCalculateDiscount_ShouldReturnFifteenPercent_WhenPointsAreOneHundred() {
        // Arrange
        double total = 200.00;
        int points = 100;
        double expected = 30.00;

        // Act
        double actual = calculator.calculateDiscount(total, points);

        // Assert
        assertEquals(expected, actual, 0.001);
    }

    // --- Edge Cases / Boundaries ---
    @Test
    public void testCalculateDiscount_ShouldReturnTenPercent_WhenPointsAreExactlyFifty() {
        // Arrange
        double total = 100.00;
        int points = 50; // Exact boundary for 10%
        double expected = 10.00;

        // Act
        double actual = calculator.calculateDiscount(total, points);

        // Assert
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCalculateDiscount_ShouldThrowException_WhenTotalIsNegative() {
        // Arrange
        double negativeTotal = -5.00;
        int points = 10;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDiscount(negativeTotal, points);
        });
    }
}