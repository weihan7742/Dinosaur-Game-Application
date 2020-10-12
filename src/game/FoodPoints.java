package game;

import java.util.HashMap;

/**
 * A class used to contain food points for different food items.
 */
public class FoodPoints {

    private HashMap<Character, Integer> foodPoints = new HashMap<Character, Integer>();

    /**
     * Method to allocate food points to different food items.
     */
    private void createFoodPoints() {
        foodPoints.put('o', 30);
        foodPoints.put('h', 20);
        foodPoints.put('^', 5);
        foodPoints.put('V', 100);
        foodPoints.put('C', 100);
        foodPoints.put('0', 10);
        foodPoints.put('%', 50);
    }

    /**
     * Getter method to retrieve hash map of food points of food items.
     *
     * @return hash map of food points of food items
     */
    public HashMap<Character, Integer> getFoodPoints() {
        createFoodPoints();
        return new HashMap<>(foodPoints);
    }
}
