package game;


import edu.monash.fit2099.engine.*;

/**
 * A herbivorous dinosaur.
 *
 */
public class Stegosaur extends Dinosaur {
	private final int MAXIMUM_FOOD_LEVEL = 100;

	/**
	 * Constructor.
	 * All Stegosaurs are represented by a 'd' and have 100 hit points.
	 *
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name, Boolean male) {
		super(name, 'd', 100,  male, 50, "Stegosaur");
		addCapability(DinosaurCapability.HERBIVORE);
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
		return super.playTurn(actions, lastAction, map, display);
	}

	@Override
	public boolean AttackAbility() {
		return false;
	}
}
