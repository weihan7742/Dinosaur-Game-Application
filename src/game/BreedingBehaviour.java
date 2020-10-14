package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

/**
 * A class which allows Dinosaur to breed.
 */
public class BreedingBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            if(exit.getDestination().containsAnActor() && exit.getDestination().getActor() instanceof BreedingInterface) {
                Actor partner = exit.getDestination().getActor();
                if (((BreedingInterface)actor).capablePregnant(actor, partner)) {
                    return new BreedingAction(partner);
                }
            }
            for (Exit exit1 : exit.getDestination().getExits()) {
                if (exit1.getDestination().containsAnActor() && exit1.getDestination().getActor() instanceof BreedingInterface) {
                    Actor partner = exit1.getDestination().getActor();
                    if (((BreedingInterface)actor).capablePregnant(actor, partner)) {
                        if (new FollowBehaviour(exit1.getDestination().getActor()).getAction(actor, map) != null) {
                            return new FollowBehaviour(exit1.getDestination().getActor()).getAction(actor, map);
                        }
                    }
                }
            }
        }
        return null;
    }
}
