package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action which allows Dinosaur to eat food items.
 */
public class EatFoodAction extends Action implements FoodInterface {

    private Ground groundFood;
    private Item dinosaurFood;

    /**
     * Constructor.
     *
     * @param dinosaurFood Item to be eaten
     */
    public EatFoodAction(Item dinosaurFood) {
        this.dinosaurFood = dinosaurFood;
    }

    /**
     * Constructor.
     *
     * @param groundFood Grass to be eaten
     */
    public EatFoodAction(Ground groundFood) {
        this.groundFood = groundFood;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        //Check if the food is a Item or a Ground
        if (dinosaurFood != null) {
            ((EatingInterface) actor).increaseFoodLevel(food.getFoodPoint
                    (dinosaurFood.getDisplayChar()));
            if (map.locationOf(actor).getItems().contains(dinosaurFood)) {
                map.locationOf(actor).removeItem(dinosaurFood);
            }
            return menuDescription(actor) + dinosaurFood;

        } else if (groundFood != null) {
            map.locationOf(actor).setGround(new Dirt());
            ((EatingInterface) actor).increaseFoodLevel(food.getFoodPoint(groundFood.getDisplayChar()));
            return menuDescription(actor) + "grass";
        }
        return null;
    }

    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
