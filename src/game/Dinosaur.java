package game;

import edu.monash.fit2099.engine.*;

/**
 * An abstract class which represents Dinosaur.
 */
public abstract class Dinosaur extends Actor implements EatingInterface,BreedingInterface{

    private boolean male;
    private boolean pregnant;
    private String species;
    private Behaviour[] behaviours = {new EatFoodBehaviour(), new MoveToFoodBehaviour(), new BreedingBehaviour(), new AttackBehaviour(), new WanderBehaviour()};
    private int turn;
    private int period;
    protected int foodLevel;
    private final static int MINIMUM_FOOD_LEVEL = 0;
    private final static int MAXIMUM_FOOD_LEVEL = 100;

    /**
     * Constructor.
     *
     * @param name        the name of the Actor
     * @param displayChar the character that will represent the Actor in the display
     * @param hitPoints   the Actor's starting hit points
     */
    public Dinosaur(String name, char displayChar, int hitPoints, boolean male, int foodLevel, String species) {
        super(name, displayChar, hitPoints);
        this.male = male;
        this.foodLevel = foodLevel;
        this.species = species;
    }

    @Override
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return new Actions(new AttackAction(this));
    }

    /**
     * Dinosaur can be hungry and has different Capabilities based on different food level.
     *
     * @param actor Dinosaur actor
     * @param map Current game map
     * @param display I/O which allows message to be displayed to the user.
     */
    public void hunger(Actor actor, GameMap map, Display display) {
        if (foodLevel < 30 && foodLevel > 0) {
            display.println(actor + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is getting hungry");
            if ((!hasCapability(DinosaurCapability.HUNGRY))) {
                addCapability(DinosaurCapability.HUNGRY);
            }
        } else if (foodLevel >= 30) {
            removeCapability(DinosaurCapability.HUNGRY);
            if (foodLevel >= 60) {
                addCapability(DinosaurCapability.HEALTHY);
            }
        } else {
            addCapability(DinosaurCapability.UNCONSCIOUS);
        }
    }

    /**
     * Decrease food level by one.
     */
    public void decreaseFoodLevel(int point) {
        if (foodLevel > MINIMUM_FOOD_LEVEL) {
            foodLevel -= point;
        }
    }

    /**
     * Increase food level based on food points.
     *
     * @param foodPoints
     */
    public void increaseFoodLevel(int foodPoints) {
        if (foodLevel + foodPoints <= MAXIMUM_FOOD_LEVEL) {
            foodLevel += foodPoints;
        }
        else {
            foodLevel = 100;
        }
    }

    /**
     * Setter method to set whether Dinosaur is pregnant or not.
     *
     * @param pregnant True if Dinosaur is pregnant, False if Dinosaur is not pregnant
     */
    public void setPregnant(boolean pregnant) {
        this.pregnant = pregnant;
    }

    /**
     * Getter method to retrieve Dinosaur's pregnancy status.
     *
     * @return True if Dinosaur is pregnant, False if Dinosaur is not pregnant
     */
    public boolean isPregnant() {
        return pregnant;
    }

    /**
     * Getter method to retrieve Dinosaur's gender.
     *
     * @return True if Dinosaur is male, False if Dinosaur is female
     */
    public boolean isMale() {
        return male;
    }

    public String gender() {
        if (isMale()) {
            return "Male";
        } else {
            return "Female";
        }
    }

    /**
     * Method to represent the state of unconscious.
     *
     * @param display Current I/O that will be shown to user
     * @param map Current running game map
     * @return DoNothingAction object which represents that actor will do nothing.
     */
    public Action unconscious(Display display, GameMap map) {
        //After 20 turns of being unconscious, dinosaur will die
        turn ++;
        if (hasCapability(DinosaurCapability.UNCONSCIOUS)) {
            if (turn == 20) {
                addCapability(DinosaurCapability.DEAD);
                display.println(this.name + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is dead");
                return new DeadActorAction();
            } else if (foodLevel > 0) {
                removeCapability(DinosaurCapability.UNCONSCIOUS);
            }
            return new DoNothingAction();
        }
        return null;
    }

    public boolean capablePregnant(Actor actor, Actor partner) {
        if (actor.hasCapability(DinosaurCapability.HEALTHY) && (actor.hasCapability(DinosaurCapability.ADULT) && !(isPregnant()))) {
            if (partner.hasCapability(DinosaurCapability.HEALTHY) && (actor.hasCapability(DinosaurCapability.ADULT) && !((BreedingInterface) partner).isPregnant())) {
                return this.isMale() != ((BreedingInterface) partner).isMale();
            }
        }
        return false;
    }

    public void birthing(GameMap map) {
        if (isPregnant()) {
            period ++;
            if (period == 10) {
                map.locationOf(this).addItem(new DinosaurEgg(species));
                setPregnant(false);
            }
        }
    }


    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        //prints foodLevel (for debugging purpose, remove later) TODO
        display.println(this.name + " at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);

        //Decrease foodLevel by 1
        decreaseFoodLevel(1);

        //Checking the foodLevel and add or remove capabilities respectively
        hunger(this, map, display);

        Action action = unconscious(display,map);
        if (action != null) {
            return action;
        }

        // After 10 turns of being pregnant, dinosaur will create new DinosaurEgg object
        birthing(map);

        for (Behaviour behaviour : behaviours) {
            if (behaviour.getAction(this, map) != null)
                return behaviour.getAction(this, map);
        }
        return new DoNothingAction();
    }

}
