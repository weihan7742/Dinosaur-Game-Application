package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

/**
 * Interface to allow implementation of drinking for actor
 */
public interface DrinksInterface {

    /**
     * Method to increase food level.
     *
     * @param point points to be added to water level
     */
    void decreaseWaterLevel(int point);

    /**
     * Method to decrease food level.
     *
     * @param point points to be deducted from water level
     */
    void increaseWaterLevel(int point);

    /**
     * Method to represent thirsty feature of actor
     *
     * @param actor current actor
     * @param map current running game map
     * @param display current I/O for system
     */
    void thirst(Actor actor, GameMap map, Display display);
}
