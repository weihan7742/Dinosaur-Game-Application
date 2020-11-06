package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

/**
 * Child class of Dinosaur which represents a large adult carnivorous dinosaur
 */
public class Archaeopteryx extends Dinosaur {
    /**
     * Constructor.
     *
     * All Archaeopteryxs are represented by 'x' and have 100 hit points, food level of 50
     * All Archaeopteryxs can traverse water and have capability ACROSSWATER
     * Archaeopteryx has capability LARGE for its large size
     *
     * @param name        the name of the Actor
     * @param male        true if male, false if female
     */
    public Archaeopteryx(String name, boolean male) {
        super(name, 'x', 100, male, 50, "Archaeopteryx");
        addCapability(DinosaurCapability.ACROSS_WATER);
        addCapability(DinosaurCapability.CARNIVORE);
        addCapability(DinosaurCapability.ADULT);
        addCapability(DinosaurCapability.LARGE);
        food.addFood(this.displayChar, 30);
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
