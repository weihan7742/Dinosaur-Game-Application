package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class SearchFruitBehaviour implements Behaviour {
    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (map.locationOf(actor).getGround().getDisplayChar() == '+' || map.locationOf(actor).getGround().getDisplayChar() == 't' || map.locationOf(actor).getGround().getDisplayChar() == 'T') {
            return new SearchFruitAction(map.locationOf(actor));
        }

        return null;
    }
}


