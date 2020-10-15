package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Location;

import java.util.List;

/**
 * A class to compute different type of distances.
 */
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

    /**
     * Find the exit which has the shortest distance from location of Actor.
     *
     * @param actorLocation Current location of Actor in the GameMap
     * @param exits List of exits
     * @return Exit which is the shortest distance from location of Actor.
     */
    public Exit shortestDistance(Location actorLocation, List<Exit> exits) {
        Exit currentExit = exits.get(0);
        int currentDistance = distance(actorLocation, currentExit.getDestination());
        for (Exit exit : exits) {
            int newDistance = distance(actorLocation, exit.getDestination());
            if (newDistance < currentDistance) {
                currentDistance = newDistance;
                currentExit = exit;
            }
        }
        return currentExit;
    }
}
