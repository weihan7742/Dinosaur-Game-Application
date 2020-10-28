package game;

import edu.monash.fit2099.engine.*;

public class DrinkAction extends Action implements FoodInterface {

    private Ground drink;

    public DrinkAction (Ground drink) {
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
    public String menuDescription(Actor actor) {
        return actor + " drinks water";
    }
}
