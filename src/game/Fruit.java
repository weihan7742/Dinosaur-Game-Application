package game;

import edu.monash.fit2099.engine.Location;

/**
 * A child class of FoodItem which represents fruit in the game.
 */
public class Fruit extends FoodItem {

    private int age;

    /**
     * Constructor.
     */
    public Fruit() {
        super("Fruit", 'o');
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
