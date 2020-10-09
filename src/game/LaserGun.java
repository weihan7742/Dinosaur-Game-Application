package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.WeaponItem;

public class LaserGun extends WeaponItem {
    private int age = 100;

    public LaserGun(){
        super("Laser Gun", 'L', 50,"zaps");
    }

    // Remove item from inventory once expired
    @Override
    public void tick(Location currentLocation, Actor actor){
        super.tick(currentLocation,actor);
        age--;

        if (age == 0){
            actor.removeItemFromInventory(this);
        }
    }
}
