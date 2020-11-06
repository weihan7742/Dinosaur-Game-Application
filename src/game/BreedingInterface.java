package game;

import edu.monash.fit2099.engine.Actor;

/**
 * Interface to allow implementation of breeding.
 */
public interface BreedingInterface {

    /**
     * Allow pregnancy feature to be implemented.
     *
     * @param pregnant yes if pregnant, no otherwise
     */
    void setPregnant(boolean pregnant);

    /**
     * Check if an Actor is pregnant.
     *
     * @return yes if pregant, no otherwise
     */
    boolean isPregnant();

    /**
     * Check if an Actor is male.
     *
     * @return
     */
    boolean isMale();

    /**
     * Check if an Actor is capable of being pregnant.
     *
     * @param actor Actor acting
     * @param partner Partner actor of actor acting
     * @return
     */
    boolean capablePregnant(Actor actor, Actor partner);

}
