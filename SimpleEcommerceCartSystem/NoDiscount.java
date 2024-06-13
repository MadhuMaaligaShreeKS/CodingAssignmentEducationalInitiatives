package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;

class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalBill, User user) {
        // Example: Buy one get one free applied on eligible items
        // Simplified example, in reality you would need to check eligible products in the cart
        System.out.println("NoDiscount");
        return totalBill; // Assuming a 10% discount as an example
    }
}
