package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class Archaeopteryx extends Dinosaur {
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param male
     */
    public Archaeopteryx(String name, boolean male) {
        super(name, 'x', 100, male, 50, "Archaeopteryx");
        addCapability(DinosaurCapability.ACROSSWATER);
        addCapability(DinosaurCapability.CARNIVORE);
        addCapability(DinosaurCapability.LARGE);
        point.addCorpse('X', 30);
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
