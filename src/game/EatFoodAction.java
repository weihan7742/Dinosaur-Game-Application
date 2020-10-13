package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action which allows Dinosaur to eat food items.
 */
public class EatFoodAction extends Action implements FoodInterface{

    private Ground grass;
    private Item dinosaurFood;
    private Dinosaur dino;

    /**
     * Constructor.
     *
     * @param dino Dinosaur actor acting
     * @param dinosaurFood Item to be eaten
     */
    public EatFoodAction(Actor dino, Item dinosaurFood) {
        this.dino = (Dinosaur) dino;
        this.dinosaurFood = dinosaurFood;
    }

    /**
     * Constructor.
     *
     * @param dino Dinosaur actor acting
     * @param grass Grass to be eaten
     */
    public EatFoodAction(Actor dino, Ground grass) {
        this.dino = (Dinosaur) dino;
        this.grass = grass;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (dinosaurFood != null) {
            dino.increaseFoodLevel(food.getFoodPoint(dinosaurFood.getDisplayChar()));
            if (map.locationOf(actor).getItems().contains(dinosaurFood)) {
                map.locationOf(actor).removeItem(dinosaurFood);
            }
            return menuDescription(actor) + dinosaurFood;
        } else if (grass != null) {
            map.locationOf(actor).setGround(new Dirt());
            dino.increaseFoodLevel(food.getFoodPoint(grass.getDisplayChar()));
            return menuDescription(actor) + "grass";
        }
        return null;
    }

    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
