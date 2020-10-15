package game;

import edu.monash.fit2099.engine.Ground;

/**
 * Child class of Ground which represents grass which is a type of terrain in the game.
 */
public class Grass extends Ground implements EcoPointInterface,FoodInterface {

    private final int GIVENECOPOINT = 1;

    /**
     * Constructor.
     */
    public Grass() {
        super('^');
        food.addFood(this.displayChar, 5);
        addCapability(TypeOfFood.HERBIVOROUS);
    }

    /**
     * Method to add eco point.
     */
    public void addEcoPoint(){
        ecoPoint.addEcoPoint(GIVENECOPOINT);
    }
}

