package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;


public class FeedingAction extends Action implements EcoPointInterface {
    private FoodItem food;
    private Location location;

    public FeedingAction(FoodItem food, Location location) {
        this.food = food;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.getInventory().contains(food)) {
            if(food == new Hay()){
                ecoPoint.addEcoPoint(10);
            }
            if(food == new Fruit()){
                ecoPoint.addEcoPoint(15);
            }
            actor.removeItemFromInventory(food);
            return menuDescription(actor)  + " and " + new EatFoodAction(location.getActor(), food).execute(actor, map);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds the dinosaur";
    }
}
