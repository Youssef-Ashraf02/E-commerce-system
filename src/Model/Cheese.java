package Model;

import Interfaces.Expirable;
import Interfaces.Shippable;
import Interfaces.ShippingItem;

import java.time.LocalDate;

public class Cheese extends Product implements Expirable, Shippable, ShippingItem {
    private LocalDate expirationDate;
    private double weight;

    public Cheese(String name, double price, int quantity, LocalDate expirationDate, double weight){
        super(name, price, quantity);
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    @Override
    public boolean isExpired(){
        return expirationDate.isBefore(LocalDate.now());
    }

    @Override
    public double getWeight(){
        return weight;
    }
}