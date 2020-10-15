package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

/**
 * A class which represents laser gun which is a weapon item and can be used by Player
 */
public class LaserGun extends WeaponItem implements ItemSoldInterface {

    private int age = 100;
    private final int ITEM_PRICE = 500;

    /**
     * Constructor.
     */
    public LaserGun() {
        super("Laser Gun", 'L', 50,"zaps");
        itemPriceList.put(this.toString(), ITEM_PRICE);
    }

    @Override
    public void tick(Location currentLocation, Actor actor) {
        super.tick(currentLocation,actor);
        age--;

        if (age == 0){
            actor.removeItemFromInventory(this);
        }
    }
}
