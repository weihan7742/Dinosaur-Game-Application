package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

import java.util.List;

public class FeedingBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        List<Exit> exits = map.locationOf(actor).getExits();
        for (Exit exit : exits) {
            if(exit.getDestination().containsAnActor()) {
                return new FeedingAction(actor.getInventory().get(0));
            }
        }
        return null;
    }
}
