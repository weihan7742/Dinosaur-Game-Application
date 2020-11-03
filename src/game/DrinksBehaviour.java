package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

/**
 * A class to allow Actor to have drinking behaviour when is on or besides water
 */
public class DrinksBehaviour implements Behaviour, FoodInterface {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Ground ground = map.locationOf(actor).getGround();
        if (food.containsFood(ground.getDisplayChar()) && ground.hasCapability(TypeOfFood.WATER)) {
            return new DrinkAction(actor, map, ground);
        }
        List<Exit> exits = map.locationOf(actor).getExits();
        for (Exit exit: exits) {
            Ground nextGround = exit.getDestination().getGround();
            if (food.containsFood(nextGround.getDisplayChar())
                    && nextGround.hasCapability(TypeOfFood.WATER)) {
                return new DrinkAction(actor, map, nextGround);
            }
        }
            return null;
    }

}
