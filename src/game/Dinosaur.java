package game;

import edu.monash.fit2099.engine.*;

public abstract class Dinosaur extends Actor {
    protected int foodLevel;
    private boolean gender;
    private boolean pregnant;
    private Behaviour[] behaviours = {new EatFoodBehaviour(), new BreedingBehaviour(), new AttackBehaviour(), new WanderBehaviour()};
    private int turn;
    private int period;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dinosaur(String name, char displayChar, int hitPoints, boolean gender, int foodLevel, String specie) {
        super(name, displayChar, hitPoints);
        addCapability(DinosaurCapability.ALIVE);
        this.gender = gender;
        this.foodLevel = foodLevel;
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }

    public void hunger(Actor actor, GameMap map, Display display) {
        if (foodLevel < 30 && foodLevel > 0) {
            display.println(actor + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is getting hungry");
            if ((!hasCapability(DinosaurCapability.HUNGRY))) {
                addCapability(DinosaurCapability.HUNGRY);
            }
        } else if (foodLevel >= 30) {
            removeCapability(DinosaurCapability.HUNGRY);
            if (foodLevel >= 31) {
                addCapability(DinosaurCapability.HEALTHY);
            }

        } else {
            addCapability(DinosaurCapability.UNCONSCIOUS);
        }
    }

    public void de() {
        foodLevel -= 1;
    }

    public void fed(Actor dino,int foodPoints) {
        foodLevel += foodPoints;
    }

    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    public boolean isPregnant() {
        return pregnant;
    }

    public boolean gender() {
        return gender;
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        //prints foodLevel
        display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);

        //Decrease foodLevel by 1
        de();

        //Checking the foodLevel and add or remove capabilities respectively
        hunger(this, map, display);

        //After 20 turns of being unconscious, dinosaur will die
        if (hasCapability(DinosaurCapability.UNCONSCIOUS)) {
            turn ++;
            if (turn == 20) {
                addCapability(DinosaurCapability.DEAD);
                display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is dead");
                map.removeActor(this);
            }
        }

        if (isPregnant()) {
            period ++;
            if (period == 10) {
                map.locationOf(this).addItem(new DinosaurEgg("Stegosaur"));
                setPregnant(false);
            }
        }

        for (Behaviour behaviour : behaviours) {
            if (behaviour.getAction(this, map) != null)
                return behaviour.getAction(this, map);
        }
        return new DoNothingAction();
    }

}
