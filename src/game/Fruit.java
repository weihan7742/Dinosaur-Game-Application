package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Fruit extends Item {
    private int turn;
    private Probability probability;
    private static final int chances = 60;

    public Fruit() {
        super("Fruit", 'o', true);
    }


    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);

        turn++;
        if (turn == 20) {
            currentLocation.removeItem(this);
        }
    }


    public void searchFruit(Location location) {
        probability = new Probability();
        if(probability.calculateProbability(chances)) {
            location.addItem(this);
        } else {
            System.out.println("You search the tree for fruit, but you can't find any ripe ones.");
        }
    }
}
