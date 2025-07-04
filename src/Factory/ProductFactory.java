package Factory;

import Model.*;

import java.time.LocalDate;

public class ProductFactory {
    public static Product createProduct(String type, String name, double price, int quantity, LocalDate expiry, Double weight){
        switch(type.toLowerCase()){
            case "cheese":
                return new Cheese(name, price, quantity, expiry, weight);
            case "biscuit":
                return new Biscuit(name, price, quantity, expiry);
            case "tv":
                return new TV(name, price, quantity, weight);
            case "mobile":
                return new Mobile(name, price, quantity);
            case "mobilescratchcard":
                return new MobileScratchCard(name, price, quantity);
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
}