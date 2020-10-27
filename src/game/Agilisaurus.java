package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class Agilisaurus extends Dinosaur {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param male
     */
    public Agilisaurus(String name, boolean male) {
        super(name, 'a', 100, male, 50, "Agilisaurus");
        addCapability(DinosaurCapability.ACROSSWATER);
        addCapability(DinosaurCapability.HERBIVORE);
        addCapability(DinosaurCapability.CARNIVORE);
    }

    @Override
    public boolean AttackAbility() {
        return false;
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }
}
