package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FeedingAction extends Action {
    private Item food;


    public FeedingAction(Item food) {
        this.food = food;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor.getInventory().contains(food)) {
            actor.removeItemFromInventory(food);
            return menuDescription(actor);
        }
        return null;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " feeds the dinosaur";
    }
}
