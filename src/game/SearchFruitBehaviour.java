package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * A class to allow Player to have a behaviour of searching fruits from trees when standing at location that has a Tree
 */
public class SearchFruitBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (map.locationOf(actor).getGround().getDisplayChar() == '+' || map.locationOf(actor).getGround().getDisplayChar() == 't'
                || map.locationOf(actor).getGround().getDisplayChar() == 'T') {
            return new SearchFruitAction();
        }

        return null;
    }
}


