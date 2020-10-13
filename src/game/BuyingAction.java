package game;

import edu.monash.fit2099.engine.*;

public class BuyingAction extends Action implements EcoPointInterface{
    private Item item;
    private VendingMachine vendingMachine = new VendingMachine();

    public BuyingAction(){
    }

    public BuyingAction(Item newItem){
        item = newItem;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (checkSufficient()){
            actor.addItemToInventory(item);
            ecoPoint.addEcoPoint(-vendingMachine.getItemPrice().get(item.toString()));
            return menuDescription(actor);
        }
        return actor + " has insufficient eco points."; // Insufficient point
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " buys " + item.toString();
    }

    public VendingMachine getVendingMachine(){
        return vendingMachine;
    }

    public boolean checkSufficient(){
        return ecoPoint.getEcoPoint() - vendingMachine.getItemPrice().get(item.toString()) >= 0;
    }
}
