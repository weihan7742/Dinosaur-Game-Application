package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A shop-like feature in the game which allows Player to purchase items using eco points.
 */
public class VendingMachine extends Ground {

    private ArrayList<Item> itemSold = new ArrayList<>();
    private HashMap<String,Integer> itemPrice = new HashMap<>();

    /**
     * Constructor.
     *
     * Contains multiple items to be sold.
     */
    public VendingMachine(){
        super('H');
        itemSold.add(new Hay());
        itemSold.add(new Fruit());
        itemSold.add(new CarnivoreMealKit());
        itemSold.add(new VegetarianMealKit());
        itemSold.add(new DinosaurEgg("Stegosaur"));
        itemSold.add(new DinosaurEgg("Allosaur"));
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
    public void addItemPrice(){
        itemPrice.put("Hay",20);
        itemPrice.put("Fruit",30);
        itemPrice.put("Carnivore Meal Kit", 100);
        itemPrice.put("Vegetarian Meal Kit", 500);
        itemPrice.put("Stegosaur Egg", 200);
        itemPrice.put("Allosaur Egg", 1000);
        itemPrice.put("Laser Gun",500); // Remember to change this
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
