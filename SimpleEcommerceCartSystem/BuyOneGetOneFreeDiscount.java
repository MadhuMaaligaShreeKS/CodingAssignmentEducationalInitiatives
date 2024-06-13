package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;

class BuyOneGetOneFreeDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalBill, User user) {
        // Example: Buy one get one free applied on eligible items
        // Simplified example, in reality you would need to check eligible products in the cart
        System.out.println("Buy One Get One Free applied.");
        return totalBill * 0.9; // Assuming a 10% discount as an example
    }
}
