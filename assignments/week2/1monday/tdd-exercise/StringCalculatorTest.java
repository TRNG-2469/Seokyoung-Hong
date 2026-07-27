package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator sc;

    @BeforeEach
    public void initCalc() {
        sc = new StringCalculator();
    }

    @Test
    public void testAddSimpleNumbers() {
        //Arrange
        int a = 5;
        int b = 3;

        //Act
        int result = sc.add("5,3");

        //Assert
        assertEquals(a+b, result);
    }

    @Test
    public void testMultiplySimpleNumbers() {
        //Arrange
        int a = 2;
        int b = 3;
        int c = 4;

        //Act
        int result = sc.multiply("2,3,4");

        //Assert
        assertEquals(a * b * c, result);
    }

    @Test
    public void testMultiplyEdgeCase() {
        //Arrange
        String input = "";

        //Act
        int resultNull = sc.multiply(null);
        int resultEmpty = sc.multiply("");

        //Assert
        assertEquals(0, resultNull);
        assertEquals(0, resultEmpty);
    }

    @Test
    public void testSimpleDivision() {
        //Arrange
        int a = 10;
        int b = 2;

        //Act
        double result = sc.divide("10,2");

        //Assert
        assertEquals((double)10 / 2, result);
    }

    @Test
    public void testDivisionEdgeCase() {
        assertThrows(IllegalArgumentException.class, () -> sc.divide("10, 0"));
    }


}
