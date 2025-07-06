package InventoryManagement;

import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Name: " + productName +
               ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Add a product
    public void addProduct(Product product) {
        if (products.containsKey(product.productId)) {
            System.out.println("Product ID already exists.");
        } else {
            products.put(product.productId, product);
            System.out.println("Product added.");
        }
    }

    // Update an existing product
    public void updateProduct(int productId, String name, int quantity, double price) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            product.productName = name;
            product.quantity = quantity;
            product.price = price;
            System.out.println("Product updated.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    // Delete a product
    public void deleteProduct(int productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    // Display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : products.values()) {
                System.out.println(product);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Sample operations
        inventory.addProduct(new Product(1, "Laptop", 10, 992.99));
        inventory.addProduct(new Product(2, "Mouse", 50, 17.99));
        inventory.displayProducts();

        inventory.updateProduct(1, "Gaming Laptop", 8, 1299.99);
        inventory.displayProducts();

        inventory.deleteProduct(2);
        inventory.displayProducts();
    }
}
