package game;

import edu.monash.fit2099.engine.Item;

/**
 * Child class of FoodItem which represents hay
 */
public class Hay extends PortableItem implements FoodInterface,ItemSoldInterface{

    private final int itemPrice = 20;
    /**
     * Constructor.
     */
    public Hay() {
        super("Hay", 'h');
        food.addFood(this.displayChar, 20);
        itemPriceList.put(this.toString(),itemPrice);
        addCapability(TypeOfFood.HERBIVOROUS);
    }
}
