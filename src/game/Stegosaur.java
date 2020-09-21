package game;


import edu.monash.fit2099.engine.*;

/**
 * A herbivorous dinosaur.
 *
 */
public class Stegosaur extends Dinosaur {
	// Will need to change this to a collection if Stegosaur gets additional Behaviours.
	private Behaviour[] behaviours = {new WanderBehaviour()};
	protected int turn;

	/** 
	 * Constructor.
	 * All Stegosaurs are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name) {
		super(name, 'd', 100, DinosaurCapability.ALIVE, 50);
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new AttackAction(this));
	}


	/**
	 * Figure out what to do next.
	 * 
	 * FIXME: Stegosaur wanders around at random, or if no suitable MoveActions are available, it
	 * just stands there.  That's boring.
	 * 
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);
		de();
		hunger(this, map, display);
		if (hasCapability(DinosaurCapability.DEAD)) {
			return new DoNothingAction();
		}

		if (hasCapability(DinosaurCapability.UNCONSCIOUS)) {
			turn ++;
			if (turn == 20) {
				addCapability(DinosaurCapability.DEAD);
				display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is getting hungry");
				map.removeActor(this);
			}
		}
		if (hasCapability(DinosaurCapability.HUNGRY)) {
			if (new EatFoodBehaviour().getAction(this, map) != null){
				return new EatFoodBehaviour().getAction(this, map);
			}
		}
		for (Behaviour behaviour : behaviours) {
			if (behaviour.getAction(this, map) != null)
				return behaviour.getAction(this, map);
		}
		return new DoNothingAction();
	}

}
