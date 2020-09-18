package game;

import edu.monash.fit2099.engine.*;

public class HarvestGrassAction extends Action {
    protected int x;
    protected int y;


    public HarvestGrassAction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        map.at(x,y).setGround(new Dirt());
        actor.addItemToInventory(new Hay());
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " harvested a grass";
    }
}
