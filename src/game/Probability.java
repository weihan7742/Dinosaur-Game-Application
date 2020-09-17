package game;

import java.util.Random;

public class Probability {
    Random rand = new Random();
    public Probability() { }

    public boolean calculateProbability(int chances) {
        if (rand.nextInt(100) > chances) {
            return true;
        } else {
            return false;
        }
    }
}
