package game;

/**
 * An abstract child class of PortableItem which presents portable food items.
 */
public abstract class FoodItem extends PortableItem {

    /**
     * Constructor.
     *
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public FoodItem(String name, char displayChar) {
        super(name, displayChar);
    }

}
