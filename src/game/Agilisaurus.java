package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

/**
 * Child class of Dinosaur which represents a small adult Omnivorous Dinosaur
 */
public class Agilisaurus extends Dinosaur {
    /**
     * Constructor.
     *
     * All Agilisauris are represented by 's' and has a hitPoints of 100, foodPoints of 50
     * Allow Agilisaurus to have both HERBIVORE and CARNIVORE capability
     * Agilisaurus has a SMALL capability to represent its relatively small size than other dinosaurs
     *
     * @param name the name of the Actor
     * @param male gender of the Actor, true if male, false if female
     */
    public Agilisaurus(String name, boolean male) {
        super(name, 's', 100, male, 50, "Agilisaurus");
        addCapability(DinosaurCapability.HERBIVORE);
        addCapability(DinosaurCapability.CARNIVORE);
        addCapability(DinosaurCapability.ADULT);
        addCapability(DinosaurCapability.SMALL);
        food.addFood(this.displayChar, 10);
    }

    @Override
    public boolean AttackAbility() {
        return true;
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }
}
