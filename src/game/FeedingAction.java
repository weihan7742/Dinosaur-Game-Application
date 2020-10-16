package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action to allow Player to feed Dinosaur.
 */
public class FeedingAction extends Action implements EcoPointInterface {

    private Item food;
    private Location location;

    /**
     * Constructor.
     *
     * @param food FoodItem to be fed
     * @param location Location of Actor
     */
    public FeedingAction(Item food, Location location) {
        this.food = food;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        // Check if food is a hay
        if(food.toString().equals(new Hay().toString())){
            ecoPoint.addEcoPoint(10);
        }

        // Check if food is a fruit
        if(food.toString().equals(new Fruit().toString())){
            ecoPoint.addEcoPoint(15);
        }

        actor.removeItemFromInventory(food);
        String eatingDescription = new EatFoodAction(food).execute(location.getActor(), map);
        return menuDescription(actor)  + " and " + eatingDescription;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds the dinosaur";
    }
}
