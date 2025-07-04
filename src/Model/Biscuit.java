package Model;

import Interfaces.Expirable;

import java.time.LocalDate;

public class Biscuit extends Product implements Expirable {
    private LocalDate expirationDate;

    public Biscuit(String name, double price, int quantity, LocalDate expirationDate){
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired(){
        return expirationDate.isBefore(LocalDate.now());
    }
}