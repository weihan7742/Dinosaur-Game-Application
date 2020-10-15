package game;

/**
 * A child class of FoodItem which can be consumed by Allosaur.
 */
public class CarnivoreMealKit extends PortableItem implements FoodInterface,ItemSoldInterface{

    private final int ITEMPRICE = 500;

    /**
     * Constructor.
     *
     */
    public CarnivoreMealKit(){
        super("Carnivore Meal Kit", 'C');
        food.addFood(this.displayChar,100);
        itemPriceList.put(this.toString(), ITEMPRICE);
        addCapability(TypeOfFood.CARNIVOROUS);
    }
}
