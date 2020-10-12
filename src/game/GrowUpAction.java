package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

/**
 * Special action to allow baby dinosaurs to grow into grown up dinosaurs.
 */
public class GrowUpAction extends Action {

    private Actor newActor;

    /**
     * Contructor.
     *
     * @param newActor actor acting
     */
    public GrowUpAction(Actor newActor) {
        this.newActor = newActor;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Location location = map.locationOf(actor);
        map.removeActor(actor);
        location.addActor(newActor);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "has grown up";
    }
}
