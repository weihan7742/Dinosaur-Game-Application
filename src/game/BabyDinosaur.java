package game;

import edu.monash.fit2099.engine.*;

public class BabyDinosaur extends Dinosaur{
    private int age;
    private boolean male;
    private String species;
    private int turn;
    private Behaviour[] behaviours = {new EatFoodBehaviour(), new WanderBehaviour()};

    public BabyDinosaur(String name, Boolean male, String species) {
        super(name, 'b',100, male, 10, species);
        this.male = male;
        this.species = species;
        capabilities();
    }

    private void capabilities() {
        if (species == "Allosaur") {
            addCapability(DinosaurCapability.CARNIVORE);
        } else if (species == "Stegosaur") {
            addCapability(DinosaurCapability.HERBIVORE);
        }
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        display.println("Baby Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);
        age++;
        de();
        hunger(this,map, display);
        if (age == 5 && foodLevel > 5) {
            Actor dino = null;
            if (species == "Allosaur") {
                dino = new Allosaur(male + species, male);
            } else if (species == "Stegosaur") {
                dino = new Stegosaur(male + species, male);
            }
            return new GrowUpAction(dino);
        }

        //After 20 turns of being unconscious, dinosaur will die
        if (hasCapability(DinosaurCapability.UNCONSCIOUS)) {
            turn ++;
            if (turn == 20) {
                addCapability(DinosaurCapability.DEAD);
                display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is dead");
                return new DeadActorAction();
            }
            return new DoNothingAction();
        }

        for (Behaviour behaviour : behaviours) {
            if (behaviour.getAction(this, map) != null)
                return behaviour.getAction(this, map);
        }
        return new DoNothingAction();
    }

    @Override
    public boolean AttackAbility() {
        return false;
    }
}
