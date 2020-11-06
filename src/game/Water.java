package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * Class representing water terrain type
 */
public class Water extends Ground implements FoodInterface {

    /**
     * Constructor
     */
    public Water() {
        super('~');
        food.addFood(this.displayChar, 20);
        addCapability(TypeOfFood.WATER);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(DinosaurCapability.ACROSS_WATER);
    }
}
