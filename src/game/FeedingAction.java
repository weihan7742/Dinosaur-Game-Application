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
        if(food == new Hay()){
            ecoPoint.addEcoPoint(10);
        }
        if(food == new Fruit()){
            ecoPoint.addEcoPoint(15);
        }
        actor.removeItemFromInventory(food);
        return menuDescription(actor)  + " and " + new EatFoodAction(location.getActor(), food).execute(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds the dinosaur";
    }
}
