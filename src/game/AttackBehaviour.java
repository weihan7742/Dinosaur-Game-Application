package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.GameMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AttackBehaviour implements Behaviour {

    @Override
    public Action getAction(Actor actor, GameMap map){
        // Is there an attackable Actor next to me?
        List<Exit> exits = new ArrayList<Exit>(map.locationOf(actor).getExits());
        Collections.shuffle(exits);

        if (actor.getWeapon() != null){
            for (Exit e: exits) {
                if (!(e.getDestination().containsAnActor()))
                    continue;
                else{
                    return new AttackAction(e.getDestination().getActor());
                }
            }
        }
        return null;
    }
}
