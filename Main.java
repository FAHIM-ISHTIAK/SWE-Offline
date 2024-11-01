import java.util.ArrayList;
import java.util.Scanner;

import Decorator.ComboDecorator;
import Decorator.FreeItemDecorator;
import Item.Burger;
import Item.Combo1;
import Item.Combo2;
import Item.Drink;
import Item.Fries;
import Item.Item;
import Item.Shawarma;
import Item.Wedges;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> menu = new ArrayList<Item>();
        menu.add(new Burger());
        menu.add(new Shawarma());
        menu.add(new Drink());
        menu.add(new Combo1());
        menu.add(new Combo2());
        menu.add(new Wedges());
        menu.add(new Fries());

        while(true){
            System.out.println("Press 1 to view menu");
            System.out.println("Press 2 to make combo");
            System.out.println("Press 0 to exit");
            int choice = sc.nextInt();
            if(choice == 1){
                for(int i = 0; i < menu.size(); i++){
                    System.out.println(i+1 + ". " + menu.get(i).getDetails() + " - " + menu.get(i).getPrice() + "Tk");
                }
            }
            else if(choice == 2){
                System.out.println("Enter the name of the combo");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Available commands:");
                System.out.println("Add <item name>");
                System.out.println("Remove <item name>");
                System.out.println("Discount <amount>");
                System.out.println("Free <item name>");
                System.out.println("Done");
                ComboDecorator combo = new ComboDecorator(name);
                while(true){
                    String str = sc.nextLine().trim();
                    String[] arr = str.split("\\s+", 2);
                    if(str.equalsIgnoreCase("done")){
                        break;
                    }
                    else if(arr[0].equalsIgnoreCase("Add")){
                        for(int i = 0; i < menu.size(); i++){
                            if(menu.get(i).getName().equalsIgnoreCase(arr[1])){
                                combo.addItem(menu.get(i));
                                break;
                            }
                        }
                    }
                    else if(arr[0].equalsIgnoreCase("Remove")){
                        for(int i = 0; i < combo.getItems().size(); i++){
                            if(combo.getItems().get(i).getName().equalsIgnoreCase(arr[1])){
                                combo.removeItem(combo.getItems().get(i));
                                break;
                            }
                        }
                    }
                    else if(arr[0].equalsIgnoreCase("Discount")){
                        double discount = Double.parseDouble(arr[1]);
                        combo.addDiscount(discount);
                    }
                    else if(arr[0].equalsIgnoreCase("Free")){
                        for(int i = 0; i < menu.size(); i++){
                            if(menu.get(i).getName().equalsIgnoreCase(arr[1])){
                                Item freeItemDecorator = new FreeItemDecorator(menu.get(i));
                                combo.addItem(freeItemDecorator);
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("Invalid command");
                    }
                }
                System.out.println("Your combo :");
                System.out.println(combo.getName());
                for(Item item: combo.getItems()){
                    System.out.println(" - " + item.getDetails());
                }
                System.out.println("Total price: " + combo.getOriginalPrice());
                System.out.println("Discount: " + combo.getDiscount());
                System.out.println("Discounted total price: " + combo.getPrice());
                menu.add(combo);
            }
            else if(choice == 0){
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}

