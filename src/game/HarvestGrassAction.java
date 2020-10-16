package game;

import edu.monash.fit2099.engine.*;

/**
 * Special action of a Player to harvest grass.
 */
public class HarvestGrassAction extends Action implements EcoPointInterface {

    protected int x;
    protected int y;

    /**
     * Constructor.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public HarvestGrassAction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        int givenEcoPoint = 1;

        map.at(x,y).setGround(new Dirt());
        actor.addItemToInventory(new Hay());
        ecoPoint.addEcoPoint(givenEcoPoint);    // Add 1 point after harvesting
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " harvests a grass";
    }
}
