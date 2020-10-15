package game;

import edu.monash.fit2099.engine.*;

/**
 * A class which represents the grow up product of dinosaur eggs.
 */
public class BabyDinosaur extends Dinosaur{

    private int age;
    private boolean male;
    private String species;

    /**
     * Constructor.
     *
     * @param name Name of dinosaur
     * @param male True if male, false if female
     * @param species Species of dinosaur
     */
    public BabyDinosaur(String name, Boolean male, String species) {
        super(name, 'b',100, male, 10, species);
        this.male = male;
        this.species = species;
        capabilities();
        addCapability(DinosaurCapability.JUVENILE);
    }

    /**
     * Assign carnivore or herbivore capability to baby dinosaur.
     */
    private void capabilities() {
        if (species.equals("Allosaur")) {
            addCapability(DinosaurCapability.CARNIVORE);
        } else if (species.equals("Stegosaur")) {
            addCapability(DinosaurCapability.HERBIVORE);
        }
    }

    /**
     * A method to allow baby dinosaur to grow up.
     *
     * @return GrowUpAction of baby dinosaur
     */
    public Action aging() {
        if (age == 5 && foodLevel >= 60) {
            Actor dino = null;
            if (species == "Allosaur") {
                dino = new Allosaur(gender() + " " + species, male);
            } else if (species == "Stegosaur") {
                dino = new Stegosaur(gender() + " " + species, male);
            }
            return new GrowUpAction(dino);
        }
        return null;
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        //display.println("Baby " + species + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);
        age++;
        Action action = aging();
        if (action != null) {
            return action;
        }
        return super.playTurn(actions, lastAction, map, display);

    }

    @Override
    public boolean AttackAbility() {
        return false;
    }
}
