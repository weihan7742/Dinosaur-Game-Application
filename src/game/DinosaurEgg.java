package game;

import edu.monash.fit2099.engine.Location;

public class DinosaurEgg extends FoodItem implements EcoPointInterface{
    private int incubationPeriod = 0;
    private String species;
    private int hatchesPoints;

    public DinosaurEgg(String species) {
        super(species + " Egg", '0');
        this.species = species;
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        Probability probability =new Probability();
        incubationPeriod ++;
        if (incubationPeriod == 5) {
            calculateHatchesPoints();
            ecoPoint.addEcoPoint(getHatchesPoints());
            if(probability.calculateProbability(50)) {
                currentLocation.addActor(new BabyDinosaur("Baby " + species, false, species));
            } else {
                currentLocation.addActor(new BabyDinosaur("Baby " + species, true, species));
            }
            currentLocation.removeItem(this);
        }
    }

    public void calculateHatchesPoints(){
        if (species == "Stegosaur"){
            hatchesPoints = 100;
        }
        else{
            hatchesPoints = 1000;
        }
    }

    public int getHatchesPoints(){
        return hatchesPoints;
    }
}
