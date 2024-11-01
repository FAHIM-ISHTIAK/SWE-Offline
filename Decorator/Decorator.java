package Decorator;
import Item.Item;

public abstract class Decorator implements Item{

    protected Item item;
    
    public Decorator() {
        this.item = null;
    }
    
    public Decorator(Item item) {
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public double getPrice() {
        return item.getPrice();
    }
}
