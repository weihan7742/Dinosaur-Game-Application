package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

/**
 * A class which allows Player to feed Dinosaur.
 */
public class FeedingBehaviour implements Behaviour, FoodInterface{

    @Override
    public Action getAction(Actor actor, GameMap map) {
        List<Exit> exits = map.locationOf(actor).getExits();
        for (Exit exit : exits) {
            if(exit.getDestination().containsAnActor()) {
                for (Item item : actor.getInventory()) {
                    if (food.containsFood(item.getDisplayChar())) {
                        return new FeedingAction(item, exit.getDestination());
                    }
                }
            }
        }
        return null;
    }
}
