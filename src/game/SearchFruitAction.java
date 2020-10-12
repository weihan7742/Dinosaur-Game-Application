package game;

import edu.monash.fit2099.engine.*;

public class SearchFruitAction extends Action {

    public SearchFruitAction( ) {

    }


    @Override
    public String execute(Actor actor, GameMap map) {
        FoodItem fruit =  new Fruit();
        Probability probability = new Probability();
        if (probability.calculateProbability(40)) {
            actor.addItemToInventory(fruit);
        } else {
            System.out.println("You search the tree for fruits, but you can't find any ripe ones.");
        }

        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " picks a Fruit from the Tree";
    }


}