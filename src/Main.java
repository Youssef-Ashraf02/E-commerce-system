import Factory.ProductFactory;
import Model.Customer;
import Model.Product;
import Services.CheckoutService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        // Create products
        Product cheese = ProductFactory.createProduct(
                "cheese", "Cheddar", 50.0, 10, LocalDate.now().plusDays(5), 2.0);
        Product tv = ProductFactory.createProduct(
                "tv", "Samsung Model.TV", 2000.0, 5, null, 20.0);
        Product scratchCard = ProductFactory.createProduct(
                "mobilescratchcard", "Vodafone Card", 100.0, 20, null, null);

        // Create customer
        Customer customer = new Customer("Alice", 5000.0);

        // Add to cart
        customer.getCart().addProduct(cheese, 2);
        customer.getCart().addProduct(tv, 1);
        customer.getCart().addProduct(scratchCard, 3);

        // Checkout
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.checkout(customer);
    }
}
