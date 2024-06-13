package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;

class FreeShippingDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalBill, User user) {
        // Example: Free shipping for orders over a certain amount
        if (totalBill >10000) {
            System.out.println("Free shipping applied.");
            // Assuming free shipping gives a fixed discount, e.g., 500
            return totalBill - 500;
        }
        return totalBill;
    }
}
