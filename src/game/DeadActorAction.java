package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Special Action for Actor for being dead.
 */
public class DeadActorAction extends Action {

    @Override
    public String execute(Actor actor, GameMap map) {
        map.locationOf(actor).addItem(new Corpse("dead " + actor));
        map.removeActor(actor);
        return "End Game";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is dead";
    }
}
