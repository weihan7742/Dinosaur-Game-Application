package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public abstract class Dinosaur extends Actor {
    protected int foodLevel;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dinosaur(String name, char displayChar, int hitPoints, DinosaurCapability capability, int foodLevel) {
        super(name, displayChar, hitPoints);
        addCapability(capability);
        this.foodLevel = foodLevel;
    }

    public void hunger(Actor actor, GameMap map, Display display) {
        if (foodLevel < 35) {
            addCapability(DinosaurCapability.HUNGRY);
            display.println(actor + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is getting hungry");
        } else if (foodLevel > 35) {
            removeCapability(DinosaurCapability.HUNGRY);
            addCapability(DinosaurCapability.ALIVE);
        } else {
            addCapability(DinosaurCapability.UNCONSCIOUS);
        }
    }

    public void de() {
        foodLevel -= 1;
    }

    public void fed(Actor dino, int foodPoints) {
        foodLevel += foodPoints;
    }
}
