package game;

import java.util.Random;

/**
 * A class to generate probabilities for different game features. 
 */
public class Probability {

    Random rand = new Random();

    /**
     * Constructor.
     */
    public Probability() { }

    /**
     * Method to calculate chances of generating a random number less than a certain number.
     *
     * @param chances
     * @return boolean True or False if the random number generated is less than given number.
     */
    public boolean calculateProbability(int chances) {
        return rand.nextInt(100) < chances;
    }
}
