package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

public class MoveToFoodBehaviour implements Behaviour{
    private CalculateDistance distance = new CalculateDistance();

    @Override
    public Action getAction(Actor actor, GameMap map) {
        //If actor is not standing on a grass or fruit, actor will move to the nearest food source
        List<Exit> foodSource = new ArrayList<>();
        if (actor.hasCapability(DinosaurCapability.HUNGRY)) {
            List<Exit> exits = map.locationOf(actor).getExits();
            for (Exit exit : exits) {
                char d = exit.getDestination().getDisplayChar();
                if ((!exit.getDestination().containsAnActor())) {
                    if ((actor.hasCapability(DinosaurCapability.HERBIVORE) && (d == '^' || d == 'o')) ||
                            (actor.hasCapability(DinosaurCapability.CARNIVORE) && (d == '%'))) {
                        foodSource.add(exit);
                    }
                }
            }
            int i = 0;
            if (i < foodSource.size() && foodSource.get(i) != null){
                Exit destination = distance.shortestDistance(map.locationOf(actor), foodSource);
                return new MoveActorAction(destination.getDestination(), destination.getName());
            }
        }
        return null;
    }
}
