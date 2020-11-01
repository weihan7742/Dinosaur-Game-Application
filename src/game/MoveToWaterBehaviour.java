package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class MoveToWaterBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (actor.hasCapability(DinosaurCapability.THIRSTY)) {
            List<Exit> exits = map.locationOf(actor).getExits();
            for (Exit exit : exits) {
                //if (exit.getDestination().getGround().hasCapability(TypeOfFood.WATER)) {
                //    return new MoveActorAction(exit.getDestination(), exit.getName());
                //}
                for (Exit otherExit : exit.getDestination().getExits()) {
                    if (otherExit.getDestination().getGround().hasCapability(TypeOfFood.WATER)) {
                        return new MoveActorAction(exit.getDestination(), exit.getName());
                    }
                }
            }
        }
        return null;
    }
}
