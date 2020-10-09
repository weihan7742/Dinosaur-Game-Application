package game;

import edu.monash.fit2099.engine.Ground;

public class Grass extends Ground implements EcoPointInterface {
    private final int givenEcoPoint = 1;

    public Grass() {
        super('^');
    }

    public void addEcoPoint(){
        ecoPoint.addEcoPoint(givenEcoPoint);
    }
}

