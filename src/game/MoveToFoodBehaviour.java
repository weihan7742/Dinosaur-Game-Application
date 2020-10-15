package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which allows Dinosaur to move to food source when below certain food level.
 */
public class MoveToFoodBehaviour implements Behaviour,FoodInterface {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        //If actor is not standing on a food, actor will move to the nearest food source
        List<Exit> foodSource = new ArrayList<>();
        CalculateDistance distance = new CalculateDistance();
        if (actor.hasCapability(DinosaurCapability.HUNGRY)) {
            List<Exit> exits = map.locationOf(actor).getExits();
            for (Exit exit : exits) {
                if (exit.getDestination().canActorEnter(actor) && diet(actor, exit.getDestination())) {
                    foodSource.add(exit);
                }
            }
            int i = 0;
            if (i < foodSource.size() && foodSource.get(i) != null) {
                Exit destination = distance.shortestDistance(map.locationOf(actor), foodSource);
                return new MoveActorAction(destination.getDestination(), destination.getName());
            }
        }
        return null;
    }

    /**
     * Method to check if there is a suitable food source for suitable dinosaur.
     *
     * @param actor Dinosaur
     * @param destination Location in the game map
     * @return True if there is suitable food source, false if no suitable food source
     */
    private boolean diet(Actor actor, Location destination) {
        if (food.containsFood(destination.getDisplayChar())) {
            if ((destination.getGround().hasCapability(TypeOfFood.HERBIVOROUS)
                    && actor.hasCapability(DinosaurCapability.HERBIVORE))
                    || ((destination.getGround().hasCapability(TypeOfFood.CARNIVOROUS)
                    && actor.hasCapability(DinosaurCapability.CARNIVORE)))) {
                return true;
            }
            for (Item item: destination.getItems()) {
                if ((item.hasCapability(TypeOfFood.HERBIVOROUS)
                        && actor.hasCapability(DinosaurCapability.HERBIVORE))
                        || (item.hasCapability(TypeOfFood.CARNIVOROUS)
                        && actor.hasCapability(DinosaurCapability.CARNIVORE))) {
                    return true;
                }
            }
        }
        return false;
    }
}


