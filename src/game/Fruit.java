package game;

import edu.monash.fit2099.engine.Location;

/**
 * A child class of FoodItem which represents fruit in the game.
 */
public class Fruit extends PortableItem implements FoodInterface{

    private int age;

    /**
     * Constructor.
     */
    public Fruit() {
        super("Fruit", 'o');
        food.addFood(this.displayChar, 30);
        addCapability(TypeOfFood.HERBIVOROUS);
    }


    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);

        age++;
        if (age == 20) {
            currentLocation.removeItem(this);
        }
    }

}
