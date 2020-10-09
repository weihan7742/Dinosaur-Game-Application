package game;

import edu.monash.fit2099.engine.*;

public class Allosaur extends Dinosaur{

    public Allosaur(String name, boolean gender) {
        super(name, 'A', 100, gender, 50, "Allosaur");
        addCapability(DinosaurCapability.CARNIVORE);
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


