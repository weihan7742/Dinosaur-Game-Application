package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

import java.util.List;

public class CalculateDistance {
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

    public Exit shortestDistance(Location actorLocation, List<Exit> exits) {
        int currentDistance = distance(actorLocation, exits.get(0).getDestination());
        for (Exit exit : exits) {
            int newDistance = distance(actorLocation, exit.getDestination());
            if (newDistance < currentDistance) {
                return exit;
            }
        }
        return null;
    }
}
