package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Special action to allow Dinosaur to breed.
 */
public class BreedingAction extends Action {

    private Actor partner;

    /**
     * Constructor.
     *
     * @param partner Dinosaur actor
     */
    public BreedingAction(Actor partner) {
        this.partner = partner;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (actor instanceof BreedingInterface && partner instanceof BreedingInterface) {
            Probability probability = new Probability();
            if (probability.calculateProbability(40)) {
                if (((BreedingInterface) actor).isMale() && (!((BreedingInterface) partner).isMale())) {
                    ((BreedingInterface) partner).setPregnant(true);
                    return menuDescription(partner);
                } else if ((!((BreedingInterface) actor).isMale()) && (((BreedingInterface) partner).isMale())) {
                    ((BreedingInterface) actor).setPregnant(true);
                    return menuDescription(actor);
                }
            }
        }
        return "Failed to breed";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is pregnant.";
    }
}

