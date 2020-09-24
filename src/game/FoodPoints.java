package game;

import java.util.HashMap;

public class FoodPoints {

    private HashMap<Character, Integer> foodPoints = new HashMap<Character, Integer>();

    private void createFoodPoints() {
        foodPoints.put('o', 30);
        foodPoints.put('h', 20);
        foodPoints.put('^', 5);
        foodPoints.put('V', 100);
        foodPoints.put('C', 100);
        foodPoints.put('0', 10);
        foodPoints.put('%', 50);
    }

    public HashMap<Character, Integer> getFoodPoints() {
        createFoodPoints();
        return new HashMap<>(foodPoints);
    }
}
