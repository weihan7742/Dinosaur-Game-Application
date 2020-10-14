package game;

import edu.monash.fit2099.engine.*;

/**
 * A class to allow Actor to have eating food behaviour.
 */
public class EatFoodBehaviour implements Behaviour,FoodInterface {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        //If actor is standing on grass or a fruit, actor will eat it
        if (actor.hasCapability(DinosaurCapability.HERBIVORE)) {
            if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
                return new EatFoodAction(map.locationOf(actor).getGround());
            }
            for (Item item : map.locationOf(actor).getItems()) {
                if (food.containsFood(item.getDisplayChar())) {
                    return new EatFoodAction(item);
                }
            }
        } else if (actor.hasCapability(DinosaurCapability.CARNIVORE)) {
            for (Item item : map.locationOf(actor).getItems()){
                if (item.getDisplayChar() == '%') {
                    return new EatFoodAction(item);
                }
            }
        }
        return null;
    }
}
