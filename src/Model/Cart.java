package Model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addProduct(Product product, int quantity){
        if(quantity <=0){
            throw new IllegalArgumentException("Quantity must be > 0.");
        }
        if(!product.isAvailable(quantity)){
            throw new IllegalArgumentException("Not enough quantity available.");
        }
        items.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems(){
        return items;
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void clear(){
        items.clear();
    }
}