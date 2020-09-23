package game;

import edu.monash.fit2099.engine.Item;

public class FoodItem extends PortableItem {

    /***
     * Constructor.
     *  @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     */
    public FoodItem(String name, char displayChar) {
        super(name, displayChar);
    }
}
