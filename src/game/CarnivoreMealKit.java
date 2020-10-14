package game;

/**
 * A child class of FoodItem which can be consumed by Allosaur.
 */
public class CarnivoreMealKit extends PortableItem implements FoodInterface{

    /**
     * Constructor.
     */
    public CarnivoreMealKit(){
        super("Carnivore Meal Kit", 'C');
        food.addFood(this.displayChar,100);
        addCapability(TypeOfFood.CARNIVOROUS);
    }
}
