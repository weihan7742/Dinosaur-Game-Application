package game;

/**
 * A child class of FoodItem which can be consumed by Stegosaur.
 */
public class VegetarianMealKit extends PortableItem implements FoodInterface{

    /**
     * Constructor.
     */
    public VegetarianMealKit(){
        super("Vegetarian Meal Kit", 'V');
        food.addFood(this.displayChar, 100);
    }
}
