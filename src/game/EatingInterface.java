package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public interface EatingInterface {
    void increaseFoodLevel(int foodPoints);

    void decreaseFoodLevel(int point);

    void hunger(Actor actor, GameMap map, Display display);

}
