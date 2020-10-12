package game;

import edu.monash.fit2099.engine.*;

/**
 * A class to allow Actor to have eating food behaviour.
 */
public class EatFoodBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {

        //If actor is standing on grass or a fruit, actor will eat it
        if (actor.hasCapability(DinosaurCapability.HERBIVORE)) {
            if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
                return new EatFoodAction(actor, new Grass());
            }
            for (Item item : map.locationOf(actor).getItems()) {
                if (item.toString() == "Fruit") {
                    map.locationOf(actor).removeItem(new Fruit());
                    return new EatFoodAction(actor, new Fruit());
                } else if (item.toString() == "Hay") {
                    map.locationOf(actor).removeItem(new Hay());
                    return new EatFoodAction(actor, new Hay());
                }
            }
        } else if (actor.hasCapability(DinosaurCapability.CARNIVORE)) {
            if (map.locationOf(actor).getGround().getDisplayChar() == '%'){
            return new EatFoodAction(actor, new Corpse("dead"));
            }
        }
        return null;
    }
}
