package Item;
import java.util.ArrayList;


public class Combo2 implements Item {
    
    protected ArrayList<Item> items;
    
    public Combo2() {
        items = new ArrayList<Item>();
        items.add(new Shawarma());
        items.add(new Drink());
    }
    
    public String getName() {
        return "Combo2";
    }
    
    public String getDetails() {
        return "Combo2(Shawarma + Drink)";
    }

    public double getPrice() {
        return 215.0;
    }
    
}
