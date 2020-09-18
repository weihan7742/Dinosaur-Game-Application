package game;

import edu.monash.fit2099.engine.*;

public class HarvestPlant extends Action {

    private Item plant;
    private Item fruit = new Fruit();
    private Location location;
    private Ground grass;
    private Item hay = new Hay();

    public HarvestPlant(Item plant, Location location) {
        this.plant = plant;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        char plantChar = location.getDisplayChar();
        location.removeItem(plant);

        if (plantChar == 'o') {
                actor.addItemToInventory(fruit);
        } else if (plantChar == '^') {
            location.setGround(new Dirt());
            actor.addItemToInventory(hay);
        }

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + "harvested" + plant.toString();
    }

}