package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;

public class BreedingAction extends Action{

    private Location location;
    private Dinosaur dino;

    public BreedingAction(Actor dino, Location location) {
        this.dino = (Dinosaur) dino;
        this.location = location;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        Probability probability = new Probability();
        Dinosaur dino1 = (Dinosaur) location.getActor();
        if (dino.gender() && (!dino1.gender())) {
            if (probability.calculateProbability(40)) {
                dino1.setPregnant(true);
                return menuDescription(dino1);
            }
        }
        else if ((!dino.gender()) && (dino1.gender())) {
            if (probability.calculateProbability(40)) {
                dino.setPregnant(true);
                return menuDescription(dino);
            }
        }
        return "Failed to breed";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + " is pregnant.";
    }
}

