package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that figures out a MoveAction that will move the actor one step 
 * closer to a target Actor.
 */
public class FollowBehaviour implements Behaviour {

	private Actor target;
	private CalculateDistance distance = new CalculateDistance();

	/**
	 * Constructor.
	 * 
	 * @param subject the Actor to follow
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		List<Exit> exits = new ArrayList<>();
		if(!map.contains(target) || !map.contains(actor))
			return null;

		Location here = map.locationOf(actor);

		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				exits.add(exit);
				}
			}
		int i = 0;
		if (i < exits.size() && exits.get(i) != null) {
			Exit destination = distance.shortestDistance(here, exits);
			return new MoveActorAction(destination.getDestination(), destination.getName());
		}
		return null;
	}
}
