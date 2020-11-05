package game;

import edu.monash.fit2099.engine.Location;

/**
 * Child class of PortableItem which represents dinosaur egg which is the breeding result of Dinosaur.
 */
public class DinosaurEgg extends PortableItem implements EcoPointInterface, FoodInterface, ItemSoldInterface {

    private int incubationPeriod = 0;
    private String species;
    private int hatchesPoints;
    private static int itemPrice;
    private static final int FOOD_POINT = 40;

    /**
     * Constructor.
     *
     * @param species species of the DinosaurEgg
     */
    public DinosaurEgg(String species) {
        super(species + " Egg", '0');
        this.species = species;
        food.addFood(this.displayChar, FOOD_POINT);
        calculateItemPrice();
        itemPriceList.put(this.toString(),itemPrice);
        addCapability(TypeOfFood.CARNIVOROUS);
    }

    @Override
    public void tick(Location currentLocation) {
        super.tick(currentLocation);
        Probability probability =new Probability();
        incubationPeriod ++;
        if (incubationPeriod == 20) {
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

    /**
     * Method to calculate hatches points.
     */
    public void calculateHatchesPoints() {
        if (species == "Stegosaur") {
            hatchesPoints = 100;
        } else if (species == "Allosaur"){
            hatchesPoints = 1000;
        } else if (species == "Agilisaurus"){
            hatchesPoints = 500;
        } else if (species == "Archaeopteryx"){
            hatchesPoints = 500;
        }
    }

    /**
     * Getter method to retrieve hatches points.
     *
     * @return hatches points
     */
    public int getHatchesPoints(){
        return hatchesPoints;
    }

    /**
     * Method to calculate dinosaur egg price according to species.
     */
    public void calculateItemPrice() {
        if(species == "Stegosaur") {
            itemPrice = 200;
        } else if (species == "Allosaur") {
            itemPrice = 1000;
        } else {
            itemPrice = 600;
        }
    }
}
