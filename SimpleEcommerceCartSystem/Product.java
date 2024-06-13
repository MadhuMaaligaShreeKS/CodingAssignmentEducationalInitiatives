package CodingAssignment__.SimpleEcommerceCartSystem;

class Product implements Cloneable {
    private String name;
    private double price;
    private boolean available;
    private int quantity;

    public Product(String name, double price, boolean available, int quantity) {
        this.name = name;
        this.price = price;
        this.available = available;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    protected Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should not happen
        }
    }

    @Override
     public String toString() {
        return name + "\n" +
                "\tPrice : $" + price + "\n" +
                "\tAvailable : " + (available ? "yes" : "no") + "\n" +
                "\tQuantity : " + quantity + "\n";
    }
}
