package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public interface DrinksInterface {
    /**
     * Method to represent hungry feature of actor
     *
     * @param actor current actor
     * @param map current running game map
     * @param display current I/O for system
     */
    void hunger(Actor actor, GameMap map, Display display);

    void decreaseWaterLevel(int point);

    void increaseWaterLevel(int point);

    void thirst(Actor actor, GameMap map, Display display);
}
