package game;

import edu.monash.fit2099.engine.Ground;

public class Grass extends Ground {
    private int turn;
    private Probability probability = new Probability();

    public Grass() {
        super('^');
    }
}

