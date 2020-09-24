package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class DinosaurEgg extends Item {
    private int incubationPeriod = 0;
    private Probability probability =new Probability();

    public DinosaurEgg(String name) {
        super(name, '0', false);
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        incubationPeriod ++;
        if (incubationPeriod == 5) {
            if(probability.calculateProbability(50)) {
                currentLocation.addActor(new BabyDinosaur("Baby Stegosaur", false));
            } else {
                currentLocation.addActor(new BabyDinosaur("Baby Stegosaur", true));
            }
            currentLocation.removeItem(this);
        }
    }
}
