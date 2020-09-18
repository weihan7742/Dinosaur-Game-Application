package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;

public class Grass extends Ground {
    Probability probability = new Probability();
    private static final int begin = 2;

    public Grass() {
        super('^');
    }


}
