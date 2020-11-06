package game;


import edu.monash.fit2099.engine.*;

/**
 * Child class of Dinosaur which represents a large adult herbivorous dinosaur.
 */
public class Stegosaur extends Dinosaur {

	/**
	 * Constructor.
	 *
	 * All Stegosaurs are represented by a 'd' and have 100 hit points and food level of 50.
	 * Stegosaurs are herbivorous and has HERBIVORE capability
	 * Stegosaurs is large and has a LARGE capability
	 *
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name, Boolean male) {
		super(name, 'd', 100,  male, 50, "Stegosaur");
		addCapability(DinosaurCapability.HERBIVORE);
		addCapability(DinosaurCapability.ADULT);
		addCapability(DinosaurCapability.LARGE);
		food.addFood(this.displayChar, 20);
	}

	/**
	 * To know if Stegosaur can attack other Actors
	 * @return true if Stegosaur can attack other Actors, false if not
	 */
	@Override
	public boolean AttackAbility() {
		return false;
	}

	/**
	 * Figure out what to do next.
	 *
	 * @see edu.monash.fit2099.engine.Actor#playTurn(Actions, Action, GameMap, Display)
	 */
	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		return super.playTurn(actions, lastAction, map, display);
	}


}
