package Model;

public class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void reduceQuantity(int amount) {
        if (amount > 0 && amount <= quantity) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Not enough stock.");
        }
    }

    public boolean isAvailable(int amount){
        return quantity >= amount;
    }
}
