package com.cohort.exceptions;

public class DivisionCalculator {

    public static int divide(String numeratorStr, String denominatorStr) throws InvalidInputException {
        if (numeratorStr == null || denominatorStr == null || numeratorStr.equals("") || denominatorStr.equals("")) {
            throw new InvalidInputException("Input arguments cannot be null or empty");
        }

        int result;
        try {
            int numer = Integer.parseInt(numeratorStr);
            int denom = Integer.parseInt(denominatorStr);

            result = numer / denom;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Inputs must be valid integers. Parsing failed.");
        } catch (ArithmeticException e) {
            throw new InvalidInputException("Division by zero is mathematically undefined.");
        }

        return result;
    }

    public static void testCycle(String numerator, String denominator) {
        try {
            double result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("[CALCULATOR] Execution cycle complete.");
        }
    }

    public static void main(String[] args) {
        testCycle("100", "5");
        testCycle("100", "0");
        testCycle("abc", "5");
        testCycle(null, "5");
    }

}
