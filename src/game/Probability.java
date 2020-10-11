package game;

import java.util.Random;

public class Probability {
    Random rand = new Random();
    public Probability() { }

    public boolean calculateProbability(int chances) {
        return rand.nextInt(100) < chances;
    }
}
