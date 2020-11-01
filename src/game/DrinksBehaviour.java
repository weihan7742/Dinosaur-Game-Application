package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class DrinksBehaviour implements Behaviour, FoodInterface {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        Ground ground = map.locationOf(actor).getGround();
        if (food.containsFood(ground.getDisplayChar()) && ground.hasCapability(TypeOfFood.WATER)) {
            return new DrinkAction(actor, map, ground);
        }
        List<Exit> exits = map.locationOf(actor).getExits();
        for (Exit exit: exits) {
            Ground ground1 = exit.getDestination().getGround();
            if (food.containsFood(ground1.getDisplayChar())
                    && ground.hasCapability(TypeOfFood.WATER)) {
                return new DrinkAction(actor, map, ground1);
            }
        }
            return null;
    }

}
