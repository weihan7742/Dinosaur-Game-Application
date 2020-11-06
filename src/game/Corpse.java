package game;


/**
 * Child class of PortableItem which can be consumed by Carnivorous Dinosaurs
 */
public class Corpse extends PortableItem implements FoodInterface {

    /***
     * Constructor.
     *
     * Corpse item for dead Dinosaurs
     * @param name the name of the Corpse item
     * @param displayChar display character of the corpse
     */
    public Corpse(String name, char displayChar) {
        super("dead " + name, displayChar);
        addCapability(TypeOfFood.CARNIVOROUS);
        addCapability(DinosaurCapability.DEAD);
    }

}
