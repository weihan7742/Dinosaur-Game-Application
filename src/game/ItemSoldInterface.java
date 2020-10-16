package game;

import java.util.HashMap;

/**
 * Interface to allow implemented of items to be sold with their respective prices.
 */
public interface ItemSoldInterface {
    HashMap<String,Integer> itemPriceList = new HashMap<>();
}
