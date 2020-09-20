package game;


import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;

/**
 * A herbivorous dinosaur.
 *
 */
public class Stegosaur extends Actor {
	// Will need to change this to a collection if Stegosaur gets additional Behaviours.
	private Behaviour[] behaviours = {new WanderBehaviour()};
	protected final int MaxHitPoints = 100;
	private final int hunger = 35;
	protected int turn;

	/** 
	 * Constructor.
	 * All Stegosaurs are represented by a 'd' and have 100 hit points.
	 * 
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name) {
		super(name, 'd', 50);
	}

	@Override
	public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
		return new Actions(new AttackAction(this));
	}

	public boolean hunger(GameMap map, Display display) {
		boolean y = false;
		hurt(1);
		if (!this.isConscious()) {
			turn ++;
			if (turn >= 20) {
				display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is dead");
			} else {
				display.println("Please Feed Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") ");
			}
			y = true;
		}
		return y;
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
		display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ hitPoints);
		if (hunger(map, display)) {
			return new DoNothingAction();
		}
		if (hitPoints < 35) {
			display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is getting hungry");
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
