package game;

/**
 * Child class of FoodItem which can be consumed by Allosaur.
 */
public class Corpse extends PortableItem implements FoodInterface {

    /***
     * Constructor.
     *
     * @param name the name of this Item
     */
    public Corpse(String name) {
        super(name, '%');
        food.addFood(this.displayChar, 50);
        addCapability(TypeOfFood.CARNIVOROUS);
    }
}
