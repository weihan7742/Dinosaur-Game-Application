package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action which allows Dinosaur to eat food items.
 */
public class EatFoodAction extends Action {

    private Ground grass;
    private Item food;
    private Dinosaur dino;
    private FoodPoints foodpoints = new FoodPoints();

    /**
     * Constructor.
     *
     * @param dino Dinosaur actor acting
     * @param food FoodItem to be eaten
     */
    public EatFoodAction(Actor dino, Item food) {
        this.dino = (Dinosaur) dino;
        this.food = food;
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
        if (actor.isConscious()) {
            if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
                map.locationOf(actor).setGround(new Dirt());
            }
        }
        if (actor.hasCapability(DinosaurCapability.HERBIVORE)) {
            if (food != null) {
                dino.increaseFoodLevel(foodpoints.getFoodPoints().get(food.getDisplayChar()));
                map.locationOf(actor).removeItem(food);
                return menuDescription(actor) + food;
            } else if (grass != null) {
                dino.increaseFoodLevel(foodpoints.getFoodPoints().get(grass.getDisplayChar()));
                return menuDescription(actor) + "grass";
            }
        } else if (actor.hasCapability((DinosaurCapability.CARNIVORE))) {
            dino.increaseFoodLevel(foodpoints.getFoodPoints().get(food.getDisplayChar()));
            return menuDescription(actor) + food;
        }
        return null;
    }

    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
