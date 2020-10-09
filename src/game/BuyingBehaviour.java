package game;

import edu.monash.fit2099.engine.*;

public class BuyingBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        return null;
    }

    public Actions getMoreActions(Actor actor, GameMap map){
        Actions actions = new Actions();
        if (map.locationOf(actor).getGround().getDisplayChar() == 'H'){
            BuyingAction buyingAction = new BuyingAction();
            for(Item items: buyingAction.getVendingMachine().getItemSold()){
                actions.add(new BuyingAction(items));
            }
            return actions;
        }
        return null;
    }
}
