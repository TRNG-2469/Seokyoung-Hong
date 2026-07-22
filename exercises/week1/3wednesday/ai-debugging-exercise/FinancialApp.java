public class FinancialApp {

    /* OLD
    public static double computeScore(int totalScore, int divisor) {
        return totalScore / divisor; // Triggers ArithmeticException if divisor is 0
    }

    public static void main(String[] args) {
        System.out.println("Processing report...");
        double value = computeScore(100, 0);
        System.out.println("Calculated Value: " + value);
    } */

    public static double computeScore(int totalScore, int divisor) {
        if (divisor == 0) {
            System.out.println("Error: Divisor cannot be zero.");
            return 0.0;   // or another appropriate default value
        }

        return (double) totalScore / divisor;
    }

    public static void main(String[] args) {
        System.out.println("Processing report...");
        double value = computeScore(100, 0);
        System.out.println("Calculated Value: " + value);
    }
}