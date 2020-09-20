package game;

import edu.monash.fit2099.engine.*;

public class EatFoodAction extends Action {
    protected Item item;
    private Location location;


    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.isConscious()) {
            if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
                map.locationOf(actor).setGround(new Dirt());
                actor.heal(5);
                return menuDescription(actor) + "grass";
            } else {
                map.locationOf(actor).removeItem(item);
                actor.heal(30);
                return menuDescription(actor) + "fruit";
            }
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " eats a ";
    }
}
