package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public abstract class Dinosaur extends Actor {
    protected int foodLevel;
    private boolean gender;
    private boolean pregnant;
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dinosaur(String name, char displayChar, int hitPoints, DinosaurCapability state, boolean gender, int foodLevel) {
        super(name, displayChar, hitPoints);
        addCapability(state);
        this.gender = gender;
        this.foodLevel = foodLevel;
    }

    public void hunger(Actor actor, GameMap map, Display display) {
        if (foodLevel < 30 && foodLevel > 0) {
            display.println(actor + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is getting hungry");
            if ((!hasCapability(DinosaurCapability.HUNGRY))) {
                addCapability(DinosaurCapability.HUNGRY);
            }
        } else if (foodLevel >= 30) {
            removeCapability(DinosaurCapability.HUNGRY);
            if (foodLevel >= 31) {
                addCapability(DinosaurCapability.HEALTHY);
            }

        } else {
            addCapability(DinosaurCapability.UNCONSCIOUS);
        }
    }

    public void de() {
        foodLevel -= 1;
    }

    public void fed(Actor dino,int foodPoints) {
        foodLevel += foodPoints;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public boolean gender() {
        return gender;
    }

}
