package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Store store = new Store();
    private static final UserManager userManager = new UserManager();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        userManager.addUser(new User("admin", "admin123"));
        User currentUser = null;

        while (true) {
            currentUser = displayMainMenu(currentUser);
            while (currentUser != null) {
                if (currentUser.getUsername().equals("admin")) {
                    currentUser = handleAdminMenu(currentUser);
                } else {
                    currentUser = handleCustomerMenu(currentUser);
                }
            }
        }
    }

    private static User displayMainMenu(User currentUser) {
        while (currentUser == null) {
            System.out.println("Do you want to (1) Login or (2) Register or (3) Exit?");
            int choice = getChoiceFromUser();

            switch (choice) {
                case 1 : 
                    currentUser = loginUser();
                    break;
                case 2 :
                    registerUser();
                    break;
                case 3 : 
                    exitApplication();
                    break;
                default :  
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
        return currentUser;
    }

    private static int getChoiceFromUser() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    private static User loginUser() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        User user = userManager.findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful.");
            return user;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return null;
        }
    }

    private static void registerUser() {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();

        if (!userManager.userExists(username)) {
            while (true) {
                System.out.println("Enter password: ");
                String password = scanner.nextLine();
                if (validatePassword(password)) {
                    userManager.addUser(new User(username, password));
                    System.out.println("Registration successful. You can now login.");
                    break;
                } else {
                    System.out.println("Password must be at least 8 characters long and contain at least one number.");
                }
            }
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private static void exitApplication() {
        System.out.println("Exiting...");
        System.exit(0);
    }

    private static User handleAdminMenu(User currentUser) {
        System.out.println("\nAdmin Menu:");
        System.out.println("1. Display Products");
        System.out.println("2. Remove Product from Store");
        System.out.println("3. Display All Customers");
        System.out.println("4. Add Product to Store");
        System.out.println("5. Logout");
        System.out.println("6. Exit");

        System.out.println("Enter your choice: ");
        int choice = getChoiceFromUser();

        try {
            switch (choice) {
                case 1 : 
                    displayProducts();
                    break;
                case 2 : 
                    removeProductFromStore();
                    break;
                case 3 : 
                    userManager.displayAllCustomers();
                    break;
                case 4 : 
                    addProductToStore();
                    break;
                case 5 : {
                    currentUser = null;
                    System.out.println("Logged out.");
                }
                break;
                case 6 : 
                    exitApplication();
                    break;
                default : System.out.println("Invalid choice. Please try again.");
            }
        } catch (StoreException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
            System.out.println(e.getMessage());
        }

        return currentUser;
    }

    private static void displayProducts() {
        System.out.println("Products:");
        for (Product product : store.getProducts()) {
            System.out.println(product);
        }
    }

    private static void removeProductFromStore() throws StoreException {
        System.out.print("Enter product name to remove from store: ");
        String removeProductName = scanner.nextLine();
        Product removeProduct = store.findProductByName(removeProductName);
        store.removeProduct(removeProduct);
        System.out.println("Product removed from store.");
    }

    private static void addProductToStore() throws StoreException {
        System.out.print("Enter product name: ");
        String newProductName = scanner.nextLine().trim();

        Product existingProduct = store.getProducts().stream()
                .filter(product -> product.getName().equalsIgnoreCase(newProductName))
                .findFirst().orElse(null);

        if (existingProduct != null) {
            System.out.print("Enter quantity to add: ");
            int quantityToAdd = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            existingProduct.setQuantity(existingProduct.getQuantity() + quantityToAdd);
            System.out.println("Quantity updated for existing product: " + existingProduct.getName());
        } else {
            addNewProduct(newProductName);
        }
    }

    private static void addNewProduct(String newProductName) {
    System.out.print("Enter product price in dollars: ");
    double newProductPrice = scanner.nextDouble();
    scanner.nextLine(); // Consume newline
    boolean newProductAvailability = true; // Default to true
    System.out.print("Enter product availability (leave blank for default - available): ");
    String availabilityInput = scanner.nextLine().trim();
    if (!availabilityInput.isEmpty()) {
        newProductAvailability = Boolean.parseBoolean(availabilityInput);
    }
    System.out.print("Enter product quantity: ");
    int newProductQuantity = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    Product newProduct = new Product(newProductName, newProductPrice, newProductAvailability, newProductQuantity);
    store.addProduct(newProduct);
    System.out.println("New product added to store.");
}


    private static User handleCustomerMenu(User currentUser) {
        System.out.println("\nCustomer Menu:");
        System.out.println("1. Display Products");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. Remove Product from Cart");
        System.out.println("4. View Cart");
        System.out.println("5. Checkout");
        System.out.println("6. Logout");
        System.out.println("7. Exit");

        System.out.println("Enter your choice: ");
        int choice = getChoiceFromUser();

        try {
            switch (choice) {
                case 1 : 
                    displayProducts();
                    break;
                case 2 : 
                    addProductToCart(currentUser);
                    break;
                case 3 : 
                    removeProductFromCart(currentUser);
                    break;
                case 4 : 
                    currentUser.getCart().displayCartItems();
                    break;
                case 5 : 
                    checkout(currentUser);
                    break;
                case 6 : {
                    currentUser = null;
                    System.out.println("Logged out.");
                }
                break;
                case 7 : 
                    exitApplication();
                    break;
                default : System.out.println("Invalid choice. Please try again.");
            }
        } catch (StoreException e) {
            logger.log(Level.WARNING, e.getMessage(), e);
            System.out.println(e.getMessage());
        }

        return currentUser;
    }

    private static void addProductToCart(User currentUser) throws StoreException {
        System.out.print("Enter product name to add to cart: ");
        String addProductName = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int addQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product addProduct = store.findProductByName(addProductName);
        currentUser.getCart().addToCart(addProduct, addQuantity);
    }

    private static void removeProductFromCart(User currentUser) throws StoreException {
        System.out.print("Enter product name to remove from cart: ");
        String removeProductName = scanner.nextLine();
        CartItem cartItem = currentUser.getCart().findProductByName(removeProductName);
        if (cartItem != null) {
            System.out.print("Enter quantity to remove: ");
            int removeQuantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            currentUser.getCart().removeFromCart(cartItem.getProduct(), removeQuantity);
        } else {
            throw new StoreException("Product " + removeProductName + " is not in the cart.");
        }
    }

    private static void checkout(User currentUser) throws StoreException {
        currentUser.getCart().displayCartItems();
        System.out.println("Do you want to (1) Checkout All or (2) Checkout Specific Product?");
        int choice = getChoiceFromUser();

 if (currentUser.isFirstTimeCustomer()) {
            double totalPurchased = currentUser.getTotalPurchased();
            if (totalPurchased > 0) {
                currentUser.setFirstTimeCustomer(false); // User is no longer a first-time customer
            }
        }

        switch (choice) {
            case 1 : 
                checkoutAll(currentUser);
                break;
            case 2 : 
                checkoutSpecific(currentUser);
                break;
            default : System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void checkoutAll(User currentUser) throws StoreException {
        double totalBill = currentUser.getCart().calculateTotalBill();
        totalBill = updateDiscountStrategy(currentUser, totalBill); // Apply discount here
        System.out.println("Total Bill : Rs." + totalBill);
        reduceProductQuantity(currentUser);
        currentUser.addToTotalPurchased(totalBill);
        currentUser.getCart().clearCart();
        System.out.println("Checkout successful.");
    }

    private static void checkoutSpecific(User currentUser) throws StoreException {
        System.out.print("Enter the number of products you want to checkout: ");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        double totalSpecificBill = 0;
        StringBuilder productsCheckedOut = new StringBuilder();

                for (int i = 1; i <= numProducts; i++) {
            System.out.print("Enter product name " + i + ": ");
            String productName = scanner.nextLine();
            System.out.print("Enter quantity to checkout: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Product product = store.findProductByName(productName);
            currentUser.getCart().checkoutProduct(product, quantity);
            totalSpecificBill += product.getPrice() * quantity;
            productsCheckedOut.append(quantity).append(" ").append(product.getName()).append("(s) ");
            product.setQuantity(product.getQuantity() - quantity);
        }

        double discountedBill = updateDiscountStrategy(currentUser, totalSpecificBill); // Apply discount
        currentUser.addToTotalPurchased(discountedBill); // Update total purchased with discounted amount
        currentUser.getCart().clearCart(); // Clear cart after checkout
        System.out.println("Total Bill: Rs." + discountedBill);
        System.out.println(productsCheckedOut.toString() + "checked out from cart");
    }

    private static void reduceProductQuantity(User currentUser) throws StoreException {
        currentUser.getCart().getItems().values().forEach(cartItem -> {
            try {
                Product storeProduct = store.findProductByName(cartItem.getProduct().getName());
                int remainingQuantity = Math.max(storeProduct.getQuantity() - cartItem.getQuantity(), 0);
                storeProduct.setQuantity(remainingQuantity);
            } catch (StoreException e) {
                logger.log(Level.WARNING, e.getMessage(), e);
            }
        });
    }

    private static double updateDiscountStrategy(User currentUser, double totalBill) {
        if (currentUser.isFirstTimeCustomer()) {
            currentUser.setDiscountStrategy(new FirstTimeCustomerDiscount());
        } else if (totalBill > 20000) {
            currentUser.setDiscountStrategy(new BulkPurchaseDiscount());
        } else if (totalBill > 5000) {
            currentUser.setDiscountStrategy(new FreeShippingDiscount());
        } else {
            currentUser.setDiscountStrategy(new NoDiscount());
        }
        return currentUser.applyDiscount(totalBill);
    }

    private static boolean validatePassword(String password) {
        return password.length() >= 8 && password.chars().anyMatch(Character::isDigit);
    }
}
