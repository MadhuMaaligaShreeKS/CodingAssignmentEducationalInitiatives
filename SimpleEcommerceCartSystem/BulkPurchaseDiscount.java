package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;



class BulkPurchaseDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalBill, User user) {
        // Example: Bulk purchase discount for orders over a certain quantity
        if (totalBill > 20000) {
            System.out.println("Bulk purchase discount applied.");
            return totalBill * 0.85; // 15% discount
        }
        return totalBill;
    }
}
