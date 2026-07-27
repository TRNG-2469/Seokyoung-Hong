package ai;

public class DiscountCalculator {

    public double calculateDiscount(double orderTotal, int loyaltyPoints) {
        if (orderTotal < 0) {
            throw new IllegalArgumentException("Total cannot be negative.");
        }
        if (loyaltyPoints >= 100) {
            return orderTotal * 0.15; // 15% discount
        } else if (loyaltyPoints >= 50) {
            return orderTotal * 0.10; // 10% discount
        }
        return 0.0;
    }

}
