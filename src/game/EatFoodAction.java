package game;

import edu.monash.fit2099.engine.*;

public class EatFoodAction extends Action {
    private Ground grass;
    private Item food;
    private Dinosaur dino;
    private FoodPoints foodpoints = new FoodPoints();

    public EatFoodAction(Actor dino, Item food) {
        this.dino = (Dinosaur) dino;
        this.food = food;
    }

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
                dino.fed(actor, foodpoints.getFoodPoints().get(food.getDisplayChar()));
                return menuDescription(actor) + food;
            } else if (grass != null) {
                dino.fed(actor, foodpoints.getFoodPoints().get(grass.getDisplayChar()));
                return menuDescription(actor) + "grass";
            }
        } else if (actor.hasCapability((DinosaurCapability.CARNIVORE))) {
            dino.fed(actor, foodpoints.getFoodPoints().get(food.getDisplayChar()));
        }
        return null;
    }

    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
