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
            //Checks if an Actor is nearby and if the Actor can Eat food
            if(exit.getDestination().containsAnActor() && exit.getDestination().getActor() instanceof EatingInterface) {

                //Check if the items in the Actor inventory consists of food
                for (Item item : actor.getInventory()) {
                    if (food.containsFood(item.getDisplayChar())) {

                        //Checking the Actor's diet and the type of food
                        Actor anotherActor = exit.getDestination().getActor();
                        if ((anotherActor.hasCapability(DinosaurCapability.HERBIVORE)
                                && item.hasCapability(TypeOfFood.HERBIVOROUS))
                                || (anotherActor.hasCapability(DinosaurCapability.CARNIVORE)
                                && item.hasCapability(TypeOfFood.CARNIVOROUS))) {

                            return new FeedingAction(item, exit.getDestination());
                        }
                    }
                }
            }
        }
        return null;
    }
}
