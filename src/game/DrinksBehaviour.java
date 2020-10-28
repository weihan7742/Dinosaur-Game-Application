package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class DrinksBehaviour implements Behaviour, FoodInterface {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (food.containsFood(map.locationOf(actor).getGround().getDisplayChar()) && map.locationOf(actor).getGround().hasCapability(TypeOfFood.WATER)) {
            return new DrinkAction(map.locationOf(actor).getGround());
        }
        return null;
    }
}
