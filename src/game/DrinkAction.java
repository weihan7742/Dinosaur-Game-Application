package game;

import edu.monash.fit2099.engine.*;

public class DrinkAction extends Action implements FoodInterface {

    private Actor actor;
    private GameMap map;
    private Ground drink;

    public DrinkAction (Actor actor, GameMap map, Ground drink) {
        this.actor = actor;
        this.map = map;
        this.drink = drink;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor instanceof DrinksInterface) {
            ((DrinksInterface) actor).increaseWaterLevel(food.getFoodPoint(drink.getDisplayChar()));
            return menuDescription(actor);
        }
        return null;
    }

    @Override
    public Action getNextAction() {
        return new WanderBehaviour().getAction(actor, map);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " drinks water";
    }
}
