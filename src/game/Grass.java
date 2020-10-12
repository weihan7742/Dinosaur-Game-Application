package game;

import edu.monash.fit2099.engine.Ground;

/**
 * Child class of Ground which represents grass which is a type of terrain in the game.
 */
public class Grass extends Ground implements EcoPointInterface {

    private final int givenEcoPoint = 1;

    /**
     * Constructor.
     */
    public Grass() {
        super('^');
    }

    /**
     * Method to add eco point.
     */
    public void addEcoPoint(){
        ecoPoint.addEcoPoint(givenEcoPoint);
    }
}

