package game;

/**
 * A child class of FoodItem which can be consumed by Stegosaur.
 */
public class VegetarianMealKit extends PortableItem implements FoodInterface,ItemSoldInterface{

    private final int ITEM_PRICE = 100;

    /**
     * Constructor.
     */
    public VegetarianMealKit(){
        super("Vegetarian Meal Kit", 'V');
        food.addFood(this.displayChar, 100);
        itemPriceList.put(this.toString(), ITEM_PRICE);
        addCapability(TypeOfFood.HERBIVOROUS);
    }
}
