package game;

import edu.monash.fit2099.engine.Actor;

/**
 * Interface to allow implementation of breeding.
 */
public interface BreedingInterface {

    void setPregnant(boolean pregnant);
    boolean isPregnant();
    boolean isMale();
    boolean capablePregnant(Actor actor, Actor partner);

}
