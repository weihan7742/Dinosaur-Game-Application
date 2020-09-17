package game;

import edu.monash.fit2099.engine.*;

public class HarvestPlant extends Action {

    private Item plant;
    private Item hay = new Hay();
    private Item fruit = new Fruit();
    private Location location;

    public HarvestPlant(Item plant, Location location) {
        this.plant = plant;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        char plantChar = location.getDisplayChar();
        location.removeItem(plant);

        if( actor.getDisplayChar() == '@') {
            if (plantChar == '^') {
                actor.addItemToInventory(hay);
            } else if (plantChar == 'o') {
                actor.addItemToInventory(fruit);
            }
        }
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + "harvested" + plant.toString();
    }

}