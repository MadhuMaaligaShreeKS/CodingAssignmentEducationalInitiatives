package CodingAssignment__.SimpleEcommerceCartSystem;

class User {
    private String username;
    private String password;
    private Cart cart;
    private double totalPurchased;
    private DiscountStrategy discountStrategy;
    private boolean isFirstTimeCustomer;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.cart = new Cart();
        this.totalPurchased = 0.0;
        this.isFirstTimeCustomer = true; // Assuming a new user is a first-time customer
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalPurchased() {
        return totalPurchased;
    }

    public void addToTotalPurchased(double amount) {
        this.totalPurchased += amount;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double applyDiscount(double totalBill) {
        return discountStrategy.applyDiscount(totalBill, this);
    }

    public boolean isFirstTimeCustomer() {
        return isFirstTimeCustomer;
    }

    public void setFirstTimeCustomer(boolean isFirstTimeCustomer) {
        this.isFirstTimeCustomer = isFirstTimeCustomer;
    }
}
