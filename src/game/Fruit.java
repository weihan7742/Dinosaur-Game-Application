package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Fruit extends FoodItem {
    private int age;

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

    public int getGivenPoint(){
        final int givenPoint = 15;
        return givenPoint;
    }
}
