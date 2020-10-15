package game;

import edu.monash.fit2099.engine.*;

public class BabyDinosaur extends Dinosaur{
    private int age;
    private boolean male;
    private String species;
    private Behaviour[] behaviours = {new EatFoodBehaviour(), new MoveToFoodBehaviour(), new WanderBehaviour()};

    public BabyDinosaur(String name, Boolean male, String species) {
        super(name, 'b',100, male, 10, species);
        this.male = male;
        this.species = species;
        capabilities();
        addCapability(DinosaurCapability.JUVENILE);
    }

    private void capabilities() {
        if (species.equals("Allosaur")) {
            addCapability(DinosaurCapability.CARNIVORE);
        } else if (species.equals("Stegosaur")) {
            addCapability(DinosaurCapability.HERBIVORE);
        }
    }

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
