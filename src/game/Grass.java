package game;

import edu.monash.fit2099.engine.Ground;

/**
 * Child class of Ground which represents grass which is a type of terrain in the game.
 */
public class Grass extends Ground implements EcoPointInterface, FoodInterface {

    private static final int FOOD_POINT = 5;
    private static final int GIVEN_ECO_POINT = 1;

    /**
     * Constructor.
     */
    public Grass() {
        super('^');
        food.addFood(this.displayChar, FOOD_POINT);
        addCapability(TypeOfFood.HERBIVOROUS);
    }

    /**
     * Method to add eco point.
     */
    public void addEcoPoint(){
        ecoPoint.addEcoPoint(GIVEN_ECO_POINT);
    }
}

