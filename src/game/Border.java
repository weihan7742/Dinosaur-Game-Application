package game;

import edu.monash.fit2099.engine.*;

public class Border extends Ground {

    private Location newLocation;
    private String newDirection;
    private Boolean displayOnMenuOrNot;

    public Border(Location location, String direction, Boolean displayOrNot){
        super('-');
        this.newLocation = location;
        this.newDirection = direction;
        this.displayOnMenuOrNot = displayOrNot;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = super.allowableActions(actor,location,direction);
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
