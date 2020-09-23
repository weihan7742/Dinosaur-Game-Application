package game;

import java.util.HashMap;

public class FoodPoints {

    private HashMap<Character, Integer> foodPoints = new HashMap<Character, Integer>();

    private void createFoodPoints() {
        foodPoints.put('o', 30);
        foodPoints.put('h', 20);
        foodPoints.put('^', 5);
    }

    public HashMap<Character, Integer> getFoodPoints() {
        createFoodPoints();
        return new HashMap<>(foodPoints);
    }
}
