package game;

/**
 * Child class of FoodItem which represents hay
 */
public class Hay extends PortableItem implements FoodInterface, ItemSoldInterface {

    private static final int FOOD_POINT = 20;
    private static final int ITEM_PRICE = 20;

    /**
     * Constructor.
     */
    public Hay() {
        super("Hay", 'h');
        food.addFood(this.displayChar, FOOD_POINT);
        itemPriceList.put(this.toString(), ITEM_PRICE);
        addCapability(TypeOfFood.HERBIVOROUS);
    }
}
