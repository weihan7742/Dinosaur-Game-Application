package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class HarvestGrassBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
            int x = map.locationOf(actor).x();
            int y = map.locationOf(actor).y();
            return new HarvestGrassAction(x,y);
        }
        return null;
    }
}