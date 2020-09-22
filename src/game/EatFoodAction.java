package game;

import edu.monash.fit2099.engine.*;

import java.util.Objects;

public class EatFoodAction extends Action {
    private Ground grass;
    private Item food;
    protected Item item = new Fruit();
    private Dinosaur dino;

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
        if (food != null) {
            if (food.toString().equals("Fruit")) {
                dino.fed(actor, 30);
            } else if (food.toString().equals("Hay")) {
                dino.fed(actor, 20);
            }
            return menuDescription(actor) + food;
        } else if (grass != null) {
            dino.fed(actor, 5);
            return menuDescription(actor) + "grass";
        }
        return null;
    }


    @Override
    public String menuDescription (Actor actor){
        return actor + " eats a ";
    }
}
