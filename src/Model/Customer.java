package Model;

public class Customer {
    private String name;
    private double balance;
    private Cart cart = new Cart();

    public Customer(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public Cart getCart(){ return cart; }
    public double getBalance(){ return balance; }
    public void deductBalance(double amount){ balance -= amount; }
    public String getName(){ return name; }
}
