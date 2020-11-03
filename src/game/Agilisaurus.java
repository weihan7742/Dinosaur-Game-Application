package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class Agilisaurus extends Dinosaur{
    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param male
     */
    public Agilisaurus(String name, boolean male) {
        super(name, 's', 100, male, 50, "Agilisaurus");
        addCapability(DinosaurCapability.HERBIVORE);
        addCapability(DinosaurCapability.CARNIVORE);
        addCapability(DinosaurCapability.SMALL);
        point.addCorpse(this.displayChar, 10);
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
