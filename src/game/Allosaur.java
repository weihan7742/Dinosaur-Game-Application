package game;

import edu.monash.fit2099.engine.*;

/**
 * Child class of Dinosaur which represents a large adult carnivorous Dinosaur.
 */
public class Allosaur extends Dinosaur {

    /**
     * Constructor.
     *
     * All Allosaurs are represented by 'a' and have 100 hit points and foodLevel of 50
     * Allow Allosaur to have CARNIVORE and LARGE capability.
     *
     * @param name
     * @param gender
     */
    public Allosaur(String name, boolean gender) {
        super(name, 'a', 100, gender, 50, "Allosaur");
        addCapability(DinosaurCapability.CARNIVORE);
        addCapability(DinosaurCapability.ADULT);
        addCapability(DinosaurCapability.LARGE);
        food.addFood(this.displayChar, 50);
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        return super.playTurn(actions, lastAction, map, display);
    }


    @Override
    public boolean AttackAbility() {
        return true;
    }
}


