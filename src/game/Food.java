package game;

import java.util.HashMap;

/**
 * A class used to contain food points for different food items.
 */
public class Food implements FoodInterface {

    private HashMap<Character, Integer> foods = new HashMap<>();

    /**
     * Method to add food and its food point into the HashMap.
     */
    public void addFood(char displayChar, int foodPoint) {
        foods.put(displayChar, foodPoint);
    }

    /**
     * Method to check if food is included in the food list.
     *
     * @param displayChar character of food
     * @return True if containing, false if not containing
     */
    public boolean containsFood(char displayChar) {
        return foods.containsKey(displayChar);
    }

    /**
     * Getter method to retrieve hash map of food points of food items.
     *
     * @return hash map of food points of food items
     */
    public int getFoodPoint(char displayChar) {
        return foods.get(displayChar);
    }
}
