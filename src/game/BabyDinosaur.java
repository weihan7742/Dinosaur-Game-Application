package game;

import edu.monash.fit2099.engine.*;

public class BabyDinosaur extends Dinosaur{
    private int age;
    private boolean male;
    private Behaviour[] behaviours = {new EatFoodBehaviour(), new WanderBehaviour()};

    public BabyDinosaur(String name, Boolean male) {
        super(name, 's',100,DinosaurCapability.ALIVE, male,10);
        this.male = male;
    }

    @Override
    public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
        display.println("Baby Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);
        age++;
        de();
        hunger(this,map, display);
        if (age == 5 && foodLevel > 5) {
            map.removeActor(this);
            map.addActor(new Stegosaur("Stegosaur", male), map.locationOf(this));
            display.println("Baby dinosaur has grown up!");
            return null;
        }

        for (Behaviour behaviour : behaviours) {
            if (behaviour.getAction(this, map) != null)
                return behaviour.getAction(this, map);
        }
        return new DoNothingAction();
    }
}
