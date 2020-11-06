package game;

import edu.monash.fit2099.engine.*;

/**
 * Terrain type to allow user to move from one map to another.
 */
public class Border extends Ground {

    private Location newLocation;
    private String newDirection;
    private Boolean displayOnMenuOrNot;

    /**
     * Constructor
     *
     * @param location location to be set
     * @param direction String message to be displayed
     * @param displayOrNot boolean if it should display the direction message
     */
    public Border(Location location, String direction, Boolean displayOrNot) {
        super('-');
        this.newLocation = location;
        this.newDirection = direction;
        this.displayOnMenuOrNot = displayOrNot;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Actions actions = super.allowableActions(actor,location,direction);
        // Ensures that no multiple options appearing on the user menu
        if(displayOnMenuOrNot){
            actions.add(new MoveActorAction(newLocation,newDirection));
        }
        return actions;
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
