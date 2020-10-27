package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A shop-like feature in the game which allows Player to purchase items using eco points.
 */
public class VendingMachine extends Ground implements ItemSoldInterface {

    private ArrayList<Item> itemSold = new ArrayList<>();
    private HashMap<String,Integer> itemPrice = new HashMap<>();

    /**
     * Constructor.
     *
     * Contains multiple items to be sold.
     */
    public VendingMachine() {
        super('H');
        itemSold.add(new Hay());
        itemSold.add(new Fruit());
        itemSold.add(new CarnivoreMealKit());
        itemSold.add(new VegetarianMealKit());
        itemSold.add(new DinosaurEgg("Stegosaur"));
        itemSold.add(new DinosaurEgg("Allosaur"));
        itemSold.add(new DinosaurEgg("Agilisaurus"));
        itemSold.add(new DinosaurEgg("Archaeopteryx"));
        itemSold.add(new LaserGun());
        addItemPrice();
    }

    /**
     * Getter method to retrieve array list of items sold.
     *
     * @return array list of items sold
     */
    public ArrayList<Item> getItemSold(){
        return new ArrayList<Item>(itemSold);
    }

    /**
     * Method to add price to items.
     */
    public void addItemPrice() {
        for(Item items: itemSold) {
            itemPriceList.put(items.toString(),itemPriceList.get(items.toString()));
        }
    }

    /**
     * Getter method to retrieve item price of items
     *
     * @return hash map of item price of items.
     */
    public HashMap<String,Integer> getItemPrice(){
        return new HashMap<>(itemPrice);
    }

}
