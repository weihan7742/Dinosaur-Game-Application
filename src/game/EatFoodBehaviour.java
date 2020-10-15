package game;

import edu.monash.fit2099.engine.*;

/**
 * A class to allow Actor to have eating food behaviour when the Actor is standing on a food
 */
public class EatFoodBehaviour implements Behaviour,FoodInterface {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (actor.hasCapability(DinosaurCapability.HERBIVORE)) {

            //Check if the Ground is a type of herbivorous food
            if (food.containsFood(map.locationOf(actor).getGround().getDisplayChar())
                    && map.locationOf(actor).getGround().hasCapability(TypeOfFood.HERBIVOROUS)) {
                return new EatFoodAction(map.locationOf(actor).getGround());
            }

            //Check if the items on the ground is a type of herbivorous food
            for (Item item : map.locationOf(actor).getItems()) {
                if (food.containsFood(item.getDisplayChar()) && item.hasCapability(TypeOfFood.HERBIVOROUS)) {
                    return new EatFoodAction(item);
                }
            }

        } else if (actor.hasCapability(DinosaurCapability.CARNIVORE)) {
            //Check if the items is a type of herbivorous food
            for (Item item : map.locationOf(actor).getItems()){
                if (food.containsFood(item.getDisplayChar()) && item.hasCapability(TypeOfFood.CARNIVOROUS)) {
                    return new EatFoodAction(item);
                }
            }
        }
        return null;
    }
}
