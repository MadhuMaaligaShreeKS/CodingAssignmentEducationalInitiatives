package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
class Cart {
    private Map<String, CartItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addToCart(Product product, int quantity) throws StoreException {
        if (!product.isAvailable()) {
            throw new StoreException("Product " + product.getName() + " is not available.");
        }

        int availableQuantity = product.getQuantity();
        String productName = product.getName().toLowerCase();
        CartItem cartItem = items.get(productName);

        int currentQuantity = Optional.ofNullable(cartItem).map(CartItem::getQuantity).orElse(0);

        if (currentQuantity + quantity > availableQuantity) {
            throw new StoreException("Insufficient quantity of product " + product.getName() + " available in the store.");
        }

        if (cartItem != null) {
            cartItem.setQuantity(currentQuantity + quantity);
        } else {
            Product clonedProduct = product.clone(); // Clone the product to follow the Prototype pattern
            items.put(productName, new CartItem(clonedProduct, quantity));
        }
        System.out.println(quantity + " " + product.getName() + "(s) added to cart.");
    }

    public void removeFromCart(Product product, int quantity) {
        String productName = product.getName().toLowerCase();
        CartItem cartItem = items.get(productName);

        if (cartItem != null) {
            int currentQuantity = cartItem.getQuantity();
            if (quantity >= currentQuantity) {
                items.remove(productName);
                System.out.println(currentQuantity + " " + product.getName() + "(s) removed from cart.");
            } else {
                cartItem.setQuantity(currentQuantity - quantity);
                System.out.println(quantity + " " + product.getName() + "(s) removed from cart.");
            }
        } else {
            System.out.println("Product " + product.getName() + " is not in the cart.");
        }
    }

    public double calculateTotalBill() {
        return items.values().stream()
                    .mapToDouble(cartItem -> cartItem.getProduct().getPrice() * cartItem.getQuantity())
                    .sum();
    }

    public void displayCartItems() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Cart Items:");
            items.values().forEach(System.out::println);
        }
    }
    

    public CartItem findProductByName(String name) throws StoreException {
        return Optional.ofNullable(items.get(name.toLowerCase()))
                       .orElseThrow(() -> new StoreException("Product " + name + " not found in the cart."));
    }

    public void checkoutProduct(Product product, int quantity) {
        String productName = product.getName().toLowerCase();
        CartItem cartItem = items.get(productName);

        if (cartItem != null) {
            int currentQuantity = cartItem.getQuantity();
            if (quantity >= currentQuantity) {
                items.remove(productName);
                System.out.println(currentQuantity + " " + product.getName() + "(s) checked out from cart.");
            } else {
                cartItem.setQuantity(currentQuantity - quantity);
                System.out.println(quantity + " " + product.getName() + "(s) checked out from cart.");
            }
        } else {
            System.out.println("Product " + product.getName() + " is not in the cart.");
        }
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void clearCart() {
        items.clear();
    }
}
