package game;

/**
 * Child class of FoodItem which represents hay
 */
public class Hay extends PortableItem implements FoodInterface,ItemSoldInterface {

    private final int ITEM_PRICE = 20;
    /**
     * Constructor.
     */
    public Hay() {
        super("Hay", 'h');
        food.addFood(this.displayChar, 20);
        itemPriceList.put(this.toString(), ITEM_PRICE);
        addCapability(TypeOfFood.HERBIVOROUS);
    }
}
