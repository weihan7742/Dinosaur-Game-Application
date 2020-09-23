package game;

import edu.monash.fit2099.engine.*;

import java.util.HashMap;

public class EatFoodAction extends Action {
    private Ground grass;
    private Item food;
    private Dinosaur dino;
    private HashMap<Character, Integer> foodPoints = new HashMap<Character, Integer>();

    public EatFoodAction(Actor dino, Item food) {
        this.dino = (Dinosaur) dino;
        this.food = food;
    }

    public EatFoodAction(Actor dino, Ground grass) {
        this.dino = (Dinosaur) dino;
        this.grass = grass;
    }

    private void createFoodPoints() {
        foodPoints.put('o', 30);
        foodPoints.put('h', 20);
        foodPoints.put('^', 5);
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        createFoodPoints();
        if (actor.isConscious()) {
            if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
                map.locationOf(actor).setGround(new Dirt());
            }
        }
        if (food != null) {
            dino.fed(actor, foodPoints.get(food.getDisplayChar()));
            return menuDescription(actor) + food;
        } else if (grass != null) {
            dino.fed(actor, foodPoints.get(grass.getDisplayChar()));
            return menuDescription(actor) + "grass";
        }
        return null;
    }


    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
