package Services;

import Interfaces.Expirable;
import Interfaces.Shippable;
import Interfaces.ShippingItem;
import Model.Cart;
import Model.CartItem;
import Model.Customer;
import Model.Product;
import  Model.CartItem;
import  Model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    public void checkout(Customer customer) {
        Cart cart = customer.getCart();
        if (cart.isEmpty()) {
            throw new IllegalStateException("Cart is empty.");
        }

        double subtotal = 0.0;
        double totalWeight = 0.0;
        List<ShippingItem> shippableItems = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.product;
            if (p instanceof Expirable && ((Expirable)p).isExpired()) {
                throw new IllegalStateException("Product " + p.getName() + " is expired.");
            }
            subtotal += item.getTotalPrice();

            if (p instanceof Shippable) {
                totalWeight += ((Shippable)p).getWeight() * item.quantity;
            }
            if (p instanceof ShippingItem) {
                shippableItems.add((ShippingItem)p);
            }
        }

        double perKgFee = calculatePerKgFee(totalWeight);
        double shippingFees = totalWeight * perKgFee;
        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            throw new IllegalStateException("Insufficient balance.");
        }

        // Deduct balance and update stock
        customer.deductBalance(totalAmount);
        for (CartItem item : cart.getItems()) {
            item.product.reduceQuantity(item.quantity);
        }

        // Print checkout summary
        System.out.println();
        System.out.println("==============================================");
        System.out.println("         🛒 Checkout Summary");
        System.out.println("==============================================");
        System.out.printf("Customer Name     : %s%n", customer.getName());
        System.out.printf("Subtotal          : $%.2f%n", subtotal);
        System.out.printf("Shipping Fees     : $%.2f%n", shippingFees);
        System.out.printf("Total Paid        : $%.2f%n", totalAmount);
        System.out.printf("Remaining Balance : $%.2f%n", customer.getBalance());
        System.out.println("==============================================");
        System.out.println("          ✅ Thank you for your purchase!");
        System.out.println("==============================================");
        System.out.println();

        // Ship items
        if (!shippableItems.isEmpty()) {
            new ShippingService().shipItems(shippableItems);
        }

        // Clear cart
        cart.clear();
    }

    private double calculatePerKgFee(double weight) {
        if (weight <= 5) {
            return 5.0;
        } else if (weight <= 20) {
            return 8.0;
        } else {
            return 15.0;
        }
    }
}
