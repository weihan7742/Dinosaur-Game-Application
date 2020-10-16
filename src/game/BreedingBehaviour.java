package game;

import edu.monash.fit2099.engine.*;

/**
 * A class which allows Dinosaur to have the behaviour to breed.
 */
public class BreedingBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location exitDestination = exit.getDestination();
            if(exitDestination.containsAnActor() && exitDestination.getActor() instanceof BreedingInterface) {
                Actor partner = exitDestination.getActor();
                if (((BreedingInterface)actor).capablePregnant(actor, partner)) {
                    return new BreedingAction(partner);
                }
            }
            for (Exit exit1 : exitDestination.getExits()) {
                Location nextDestination = exit1.getDestination();
                if (nextDestination.containsAnActor() && nextDestination.getActor() instanceof BreedingInterface) {
                    Actor partner = nextDestination.getActor();
                    if (((BreedingInterface)actor).capablePregnant(actor, partner)) {
                        if (new FollowBehaviour(nextDestination.getActor()).getAction(actor, map) != null) {
                            return new FollowBehaviour(nextDestination.getActor()).getAction(actor, map);
                        }
                    }
                }
            }
        }
        return null;
    }
}
