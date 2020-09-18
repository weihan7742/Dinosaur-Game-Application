package game;

import edu.monash.fit2099.engine.Location;

public class Fruit extends PortableItem {
    private int age;
    private Probability probability;
    private static final int chances = 60;

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
