package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action of a Player to buy item from VendingMachine.
 */
public class BuyingAction extends Action implements EcoPointInterface, ItemSoldInterface {

    private Item item;

    /**
     * Constructor.
     *
     * @param newItem item to be bought
     */
    public BuyingAction(Item newItem){
        item = newItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (checkSufficient()){
            actor.addItemToInventory(item);
            ecoPoint.addEcoPoint(-itemPriceList.get(item.toString()));
            return menuDescription(actor);
        }
        return actor + " has insufficient eco points."; // Insufficient point
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item.toString();
    }

    /**
     * Check if Player has enough eco points to buy the item.
     *
     * @return True if sufficient eco points, false if insufficient eco points
     */
    public boolean checkSufficient(){
        return ecoPoint.getEcoPoint() - itemPriceList.get(item.toString()) >= 0;
    }
}
