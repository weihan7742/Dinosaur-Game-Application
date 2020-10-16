package game;

import edu.monash.fit2099.engine.*;

/**
 * A class which allows Player to buy items from VendingMachine.
 */
public class BuyingBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }

    /**
     * A method which allows Player to have multiple BuyingAction for different items from VendingMachine.
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return {@link edu.monash.fit2099.engine.Actions} which contain collection of BuyingAction
     */
    public Actions getMoreActions(Actor actor, GameMap map) {
        VendingMachine vendingMachine = new VendingMachine();
        Actions actions = new Actions();
        if (map.locationOf(actor).getGround().getDisplayChar() == vendingMachine.getDisplayChar()) {
            for(Item items: vendingMachine.getItemSold()) {
                actions.add(new BuyingAction(items));
            }
            return actions;
        }
        return null;
    }
}
