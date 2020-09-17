package game;

import edu.monash.fit2099.engine.*;

public class HarvestPlant extends Action {

    private Item plant;
    private Item hay;
    private Item fruit;
    private Location location;

    public HarvestPlant(Item plant, Location location) {
        this.plant = plant;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        location.removeItem(plant);
        char actorChar = actor.getDisplayChar();

        if(actorChar == '@') {
            if (location.getDisplayChar() == '^') {
                actor.addItemToInventory(hay);
            } else if (location.getDisplayChar() == 'o') {
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