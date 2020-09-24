package game;

import edu.monash.fit2099.engine.Location;

public class DinosaurEgg extends FoodItem {
    private int incubationPeriod = 0;
    private Probability probability =new Probability();
    private String species;

    public DinosaurEgg(String species) {
        super(species + " Egg", '0');
        this.species = species;
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        incubationPeriod ++;
        if (incubationPeriod == 5) {
            if(probability.calculateProbability(50)) {
                currentLocation.addActor(new BabyDinosaur("Baby Stegosaur", false, species));
            } else {
                currentLocation.addActor(new BabyDinosaur("Baby Stegosaur", true, species));
            }
            currentLocation.removeItem(this);
        }
    }
}
