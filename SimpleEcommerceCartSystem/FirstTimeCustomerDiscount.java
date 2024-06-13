package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;

class FirstTimeCustomerDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalBill, User user) {
        if (user.isFirstTimeCustomer()) {
            System.out.println("First time customer discount applied.");
            return totalBill * 0.8; // 20% discount
        }
        return totalBill;
    }
}
