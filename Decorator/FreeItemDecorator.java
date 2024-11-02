package Decorator;

import Item.Item;

public  class FreeItemDecorator extends Decorator {
    
    public FreeItemDecorator(Item item) {
        super(item);
    }

    public  String getName(){
        return item.getName();
    }
    
    
    public String getDetails(){
        return item.getName() + " (Free!!!)";
    }

    public  double getPrice(){
        return 0.0;
    }
    
}
