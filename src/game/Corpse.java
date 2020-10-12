package game;

/**
 * Child class of FoodItem which can be consumed by Allosaur.
 */
public class Corpse extends FoodItem{
    /***
     * Constructor.
     *
     * @param name the name of this Item
     */
    public Corpse(String name) {
        super(name, '%');
    }
}
