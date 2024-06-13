package CodingAssignment__.SimpleEcommerceCartSystem;
import java.util.ArrayList;
import java.util.List;
class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean userExists(String username) {
        return users.stream().anyMatch(user -> user.getUsername().equalsIgnoreCase(username));
    }

    public User findUserByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equalsIgnoreCase(username)).findFirst().orElse(null);
    }

    public void displayAllCustomers() {
        long customerCount = users.stream().filter(user -> !user.getUsername().equalsIgnoreCase("admin")).count();
        if (customerCount > 0) {
            System.out.println("All Customers:");
            users.stream()
                 .filter(user -> !user.getUsername().equalsIgnoreCase("admin"))
                 .forEach(user -> System.out.println("Username: " + user.getUsername() + ", Total Purchased: Rs." + user.getTotalPurchased()));
        } else {
            System.out.println("No customers registered.");
        }
    }
}
