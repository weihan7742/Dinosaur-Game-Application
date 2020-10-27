package game;

import edu.monash.fit2099.engine.*;

public class Border extends Ground {

    private Location newLocation;
    private String newDirection;

    public Border(Location location, String direction){
        super('-');
        this.newLocation = location;
        this.newDirection = direction;
    }

    @Override
    public Actions allowableActions(Actor actor, Location location, String direction){
        Actions actions = super.allowableActions(actor,location,direction);
        actions.add(new MoveActorAction(newLocation,newDirection));
        return actions;
    }
}
