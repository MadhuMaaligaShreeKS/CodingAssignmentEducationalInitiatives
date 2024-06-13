package CodingAssignmentEducationalInitiatives.SimpleEcommerceCartSystem;

import java.util.ArrayList;
import java.util.List;
class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
        // Adding initial products
        this.products.add(new Product("Laptop", 1000, true, 20));
        this.products.add(new Product("Headphones", 50, true, 50));
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public Product findProductByName(String name) throws StoreException {
        for (Product product : products) {
            if (product.getName().trim().equalsIgnoreCase(name.trim())) {
                return product;
            }
        }
        throw new StoreException("Product " + name + " not found in the store.");
    }
}
