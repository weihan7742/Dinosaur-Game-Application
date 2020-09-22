package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class EatFoodBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
            return new EatFoodAction(actor, new Grass());
        } //else if (((map.locationOf(actor).getItems() != null) && (map.locationOf(actor).getItems().get(0).toString() == "Fruit"))) {
           // map.locationOf(actor).removeItem(new Fruit());
          //  return new EatFoodAction(actor, new Fruit());
        //}
        int currentDistance = 1000;
        Location actorLocation = map.locationOf(actor);
        List<Exit> exits = actorLocation.getExits();
        for (Exit exit : exits) {
            char d = exit.getDestination().getDisplayChar();
            if ((!exit.getDestination().containsAnActor()) && (d == '^' || d == 'o')) {
                int newDistance = distance(actorLocation, exit.getDestination());
                if (newDistance < currentDistance) {
                    return new MoveActorAction(exit.getDestination(), exit.getName());
                }
            }
        }
        return null;
    }

    /**
     * Compute the Manhattan distance between two locations.
     *
     * @param a the first location
     * @param b the first location
     * @return the number of steps between a and b if you only move in the four cardinal directions.
     */
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
