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
            if(exit.getDestination().containsAnActor() && exit.getDestination().getActor() instanceof EatingInterface) {
                for (Item item : actor.getInventory()) {
                    if (food.containsFood(item.getDisplayChar())) {
                        if (exit.getDestination().getActor().hasCapability(DinosaurCapability.HERBIVORE) && item.hasCapability(TypeOfFood.HERBIVOROUS) || exit.getDestination().getActor().hasCapability(DinosaurCapability.CARNIVORE) && item.hasCapability(TypeOfFood.CARNIVOROUS))
                        return new FeedingAction(item, exit.getDestination());
                    }
                }
            }
        }
        return null;
    }
}
