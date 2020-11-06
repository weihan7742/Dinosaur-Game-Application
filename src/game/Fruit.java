package game;

import edu.monash.fit2099.engine.Location;

/**
 * A child class of FoodItem which represents fruit in the game.
 */
public class Fruit extends PortableItem implements FoodInterface, ItemSoldInterface {

    private static final int FOOD_POINT = 30;
    private static final int ITEM_PRICE = 30;
    private int age;

    /**
     * Constructor.
     */
    public Fruit() {
        super("Fruit", 'o');
        food.addFood(this.displayChar, FOOD_POINT);
        itemPriceList.put(this.toString(),ITEM_PRICE);
        addCapability(TypeOfFood.HERBIVOROUS);
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);

        age++;
        if (age == 20) {
            currentLocation.removeItem(this);
        }
    }
}
