package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine extends Ground {
    private ArrayList<Item> itemSold = new ArrayList<>();
    private HashMap<String,Integer> itemPrice = new HashMap<>();

    // Put in doc
    public VendingMachine(){
        super('H');
        itemSold.add(new Hay());
        itemSold.add(new Fruit());
//        itemSold.put(vegetarianMealKit,-100);
//        itemSold.put(carnivoreMealKit, -500);
//        itemSold.put(stegosaurEggs, -200);
//        itemSold.put(allosaurEggs,-1000);
//        itemSold.put(laserGun,-500)
        addItemPrice();
    }

    public ArrayList<Item> getItemSold(){
        return new ArrayList<Item>(itemSold);
    }

    public void addItemPrice(){
        itemPrice.put("Hay",-20);
        itemPrice.put("Fruit",-30);
    }

    public HashMap<String,Integer> getItemPrice(){
        return new HashMap<>(itemPrice);
    }
}
