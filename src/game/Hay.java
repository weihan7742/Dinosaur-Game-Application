package game;

/**
 * Child class of FoodItem which represents hay
 */
public class Hay extends PortableItem implements FoodInterface{

    /**
     * Constructor.
     */
    public Hay() {
        super("Hay", 'h');
        food.addFood(this.displayChar, 20);
        addCapability(TypeOfFood.HERBIVOROUS);
    }
}
