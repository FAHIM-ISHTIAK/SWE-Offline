package Item;

import java.util.ArrayList;

public class Combo implements Item {
    protected ArrayList<Item> items = new ArrayList<Item>();
    protected String comboName;
    protected double discount;

    public Combo() {
        super();
        this.comboName = "Combo";
        this.discount = 0.0;
    }

    public Combo(String name) {
        super();
        this.comboName = name;
        this.discount = 0.0;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public void addDiscount(double discount){
        if(this.discount + discount <= 100){
            this.discount += discount;
        }
    }

    public double getOriginalPrice(){
        double price = 0;
        for(Item item: items){
            price += item.getPrice();
        }
        return price;
    }

    @Override
    public double getPrice(){
        double originalPrice = this.getOriginalPrice();  // Fixed
        return originalPrice * (1 - this.discount / 100);  // Apply discount
    }

    @Override
    public String getName(){
        return this.comboName;
    }

    @Override
    public String getDetails(){
        StringBuilder name = new StringBuilder(this.comboName + " (");
        int i = 0;
        for(Item item: items){
            i++;
            if(i == items.size()){
                name.append(item.getName());
                break;
            }
            name.append(item.getName()).append(" + ");
        }
        name.append(")");
        return name.toString();
    }

    public double getDiscount(){
        return this.discount;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }
    
}
