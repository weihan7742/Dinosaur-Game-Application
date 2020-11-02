package game;

import java.util.HashMap;

public class CorpseFoodPoint {
    private HashMap<Character, Integer> corpses = new HashMap<>();

    public void addCorpse(char displayChar, int foodPoint) {
        corpses.put(displayChar, foodPoint);
    }

    public int corpsePoint (char displayChar) {
        return corpses.get(displayChar);
    }
}
