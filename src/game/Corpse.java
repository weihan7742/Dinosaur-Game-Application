package game;

/**
 * Child class of FoodItem which can be consumed by Allosaur.
 */
public class Corpse extends PortableItem implements FoodInterface {

    private static final int FOOD_POINT = 50;
    /***
     * Constructor.
     *
     * @param name the name of this Item
     */
    public Corpse(String name) {
        super(name, '%');
        food.addFood(this.displayChar, FOOD_POINT);
        addCapability(TypeOfFood.CARNIVOROUS);
    }
}
