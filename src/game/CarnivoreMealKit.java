package game;

/**
 * A child class of FoodItem which can be consumed by Allosaur.
 */
public class CarnivoreMealKit extends PortableItem implements FoodInterface, ItemSoldInterface {

    private static final int FOOD_POINT = 100;
    private static final int ITEM_PRICE = 500;

    /**
     * Constructor.
     *
     */
    public CarnivoreMealKit() {
        super("Carnivore Meal Kit", 'C');
        food.addFood(this.displayChar,FOOD_POINT);
        itemPriceList.put(this.toString(), ITEM_PRICE);
        addCapability(TypeOfFood.CARNIVOROUS);
    }
}
