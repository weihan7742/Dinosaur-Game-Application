package game;

import edu.monash.fit2099.engine.*;

import java.util.List;

public class EatFoodBehaviour implements Behaviour {
    private CalculateDistance dis = new CalculateDistance();

    @Override
    public Action getAction(Actor actor, GameMap map) {

        //If actor is standing on grass or a fruit, actor will eat it
        if (map.locationOf(actor).getGround().getDisplayChar() == '^') {
            return new EatFoodAction(actor, new Grass());
        }
        for (Item item : map.locationOf(actor).getItems()) {
            if (item.toString() == "Fruit"){
                map.locationOf(actor).removeItem(new Fruit());
                return new EatFoodAction(actor, new Fruit());
            } else if (item.toString() == "Hay") {
                map.locationOf(actor).removeItem(new Hay());
                return new EatFoodAction(actor, new Hay());
            }
        }

        //If actor is not standing on a grass or fruit, actor will move to the nearest food source
        if (actor.hasCapability(DinosaurCapability.HUNGRY)) {
            int currentDistance = 1000;
            Location actorLocation = map.locationOf(actor);
            List<Exit> exits = actorLocation.getExits();
            for (Exit exit : exits) {
                char d = exit.getDestination().getDisplayChar();
                if ((!exit.getDestination().containsAnActor()) && (d == '^' || d == 'o')) {
                    int newDistance = dis.distance(actorLocation, exit.getDestination());
                    if (newDistance < currentDistance) {
                        return new MoveActorAction(exit.getDestination(), exit.getName());
                    }
                }
            }
        }
        return null;
    }


}
