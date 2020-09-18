package game;

import edu.monash.fit2099.engine.*;

public class SearchFruitAction extends Action {

    private Location location;
    private Item fruit =  new Fruit();
    private Probability probability = new Probability();

    public SearchFruitAction(Location location) {
        this.location = location;
    }


    @Override
    public String execute(Actor actor, GameMap map) {
        if (probability.calculateProbability(40)) {
            actor.addItemToInventory(fruit);
        } else {
            System.out.println("You search the tree for fruits, but you can't find any ripe ones.");
        }

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "picked a Fruit from the Tree";
    }


}
