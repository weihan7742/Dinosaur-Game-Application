package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action which allows Dinosaur to eat food items.
 */
public class EatFoodAction extends Action implements FoodInterface {

    private Ground grass;
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
     * @param grass Grass to be eaten
     */
    public EatFoodAction(Ground grass) {
        this.grass = grass;
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

        } else if (grass != null) {
            map.locationOf(actor).setGround(new Dirt());
            ((EatingInterface) actor).increaseFoodLevel(food.getFoodPoint(grass.getDisplayChar()));
            return menuDescription(actor) + "grass";
        }
        return null;
    }

    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
