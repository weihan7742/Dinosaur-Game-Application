package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * Class representing water terrain type
 */
public class Water extends Ground {

    public Water(){
        super('~');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(DinosaurCapability.ACROSSWATER);
    }
}
