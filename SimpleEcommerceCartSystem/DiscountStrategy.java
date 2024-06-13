package CodingAssignment__.SimpleEcommerceCartSystem;

interface DiscountStrategy {
    double applyDiscount(double totalBill, User user);
}

