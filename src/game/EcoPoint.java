package game;

/**
 * Class representing currency of the game.
 */
public class EcoPoint {

    private int ecoPoint = 0;

    /**
     * Getter method for total eco points.
     *
     * @return total eco points
     */
    public int getEcoPoint() {
        return ecoPoint;
    }

    /**
     * Method to add more eco points to existing eco points.
     *
     * @param newPoint additional eco points.
     */
    public void addEcoPoint(int newPoint){
        ecoPoint += newPoint;
    }

    public void setEcoPoint(int ecoPoint) {
        this.ecoPoint = ecoPoint;
    }
}
