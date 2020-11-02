package game;


/**
 * Child class of FoodItem which can be consumed by Allosaur.
 */
public class Corpse extends PortableItem implements FoodInterface, CorpseInterface {


    /***
     * Constructor.
     *
     * @param name the name of this Item
     */
    public Corpse(String name, char displayChar) {
        super("dead " + name, displayChar);
        food.addFood(displayChar, point.corpsePoint(displayChar));
        addCapability(TypeOfFood.CARNIVOROUS);
        addCapability(DinosaurCapability.DEAD);
    }

}
