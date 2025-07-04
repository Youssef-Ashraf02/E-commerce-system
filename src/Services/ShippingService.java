package Services;

import Interfaces.ShippingItem;

import java.util.List;

class ShippingService {
    public void shipItems(List<ShippingItem> items){
        System.out.println("Shipping the following items:");
        for(ShippingItem item: items){
            System.out.printf("- %s (Weight: %.2f kg)%n", item.getName(), item.getWeight());
        }
    }
}