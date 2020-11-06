package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

/**
 * A class which allows Dinosaur to move to Water when below certain water level.
 */
public class MoveToWaterBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (actor.hasCapability(DinosaurCapability.THIRSTY)) {
            List<Exit> exits = map.locationOf(actor).getExits();
            for (Exit exit : exits) {
                for (Exit otherExit : exit.getDestination().getExits()) {
                    if (otherExit.getDestination().getGround().hasCapability(TypeOfFood.WATER) && !(otherExit.getDestination().containsAnActor())) {
                        return new MoveActorAction(exit.getDestination(), exit.getName());
                    }
                }
            }
        }
        return null;
    }
}
