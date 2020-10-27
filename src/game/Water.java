package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * Class representing water terrain type
 */
public class Water extends Ground implements FoodInterface{

    public Water(){
        super('~');
        food.addFood(this.displayChar, 5);
        addCapability(TypeOfFood.HERBIVOROUS);
        addCapability(TypeOfFood.CARNIVOROUS);
        addCapability(TypeOfFood.WATER);
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(DinosaurCapability.ACROSSWATER);
    }
}
