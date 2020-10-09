package game;

public class Hay extends FoodItem {

    /***
     * Constructor.
     */
    public Hay() {
        super("Hay", 'h');
    }

    public int getGivenPoint(){
        final int givenPoint = 10;
        return givenPoint;
    }
}
