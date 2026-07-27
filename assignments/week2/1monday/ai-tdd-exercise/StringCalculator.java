package ai;

public class StringCalculator {

    public int add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] tokens = input.split(",", -1);
        int sum = 0;
        for (String token : tokens) {
            sum += Math.addExact(sum, Integer.parseInt(token.trim()));
        }
        return sum;
    }

    public int multiply(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        String[] tokens = input.split(",", -1);
        int product = 1;
        for (String token : tokens) {
             product = Math.multiplyExact(product, Integer.parseInt(token.trim()));
        }
        return product;
    }

    public double divide(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0.0;
        }
        String[] tokens = input.split(",", -1);
        double divide = Double.parseDouble(tokens[0].trim());
        for (int i = 1; i < tokens.length; i++) {
            double divisor = Double.parseDouble(tokens[i].trim());

            if (divisor == 0) {
                throw new IllegalArgumentException("Division by zero is undefined.");
            }

            divide /= divisor;
        }
        return divide;
    }

}
