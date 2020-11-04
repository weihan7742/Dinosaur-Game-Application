package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

/**
 * Interface to allow implementation of eating for actor
 */
public interface EatingInterface {

    /**
     * Method to increase food level.
     *
     * @param foodPoints points to be added to food level
     */
    void increaseFoodLevel(int foodPoints);

    /**
     * Method to decrease food level.
     *
     * @param point food points to be decrease from food level
     */
    void decreaseFoodLevel(int point);

    /**
     * Method to represent hungry feature of actor
     *
     * @param actor current actor
     * @param map current running game map
     * @param display current I/O for system
     */
    void hunger(Actor actor, GameMap map, Display display);
   
}
