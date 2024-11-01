package Item;
import java.util.ArrayList;


public class Combo1 implements Item {
    
    protected ArrayList<Item> items;

    public Combo1() {
        items = new ArrayList<Item>();
        items.add(new Burger());
        items.add(new Fries());
        items.add(new Drink());
    }
    
    public String getName() {
        return "Combo1";
    }
    
    public String getDetails() {
        return "Combo1(Burger + Fries + Drink)";
    }

    public double getPrice() {
        return 400.0;
    }
    
}
