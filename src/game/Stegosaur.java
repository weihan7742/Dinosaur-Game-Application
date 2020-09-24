package game;


import edu.monash.fit2099.engine.*;

/**
 * A herbivorous dinosaur.
 *
 */
public class Stegosaur extends Dinosaur {
	// Will need to change this to a collection if Stegosaur gets additional Behaviours.
	private Behaviour[] behaviours = {new EatFoodBehaviour(), new BreedingBehaviour(), new WanderBehaviour()};
	//private Behaviour[] breedingBehaviour = {new FollowBehaviour()};
	protected int turn;
	private int period;
	private final int MAXIMUM_FOOD_LEVEL = 100;

	/**
	 * Constructor.
	 * All Stegosaurs are represented by a 'd' and have 100 hit points.
	 *
	 * @param name the name of this Stegosaur
	 */
	public Stegosaur(String name, Boolean male) {
		super(name, 'd', 100, DinosaurCapability.ALIVE, male, 50);
		addCapability(DinosaurCapability.HERBIVORE);
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
		//prints foodLevel
		display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") "+ foodLevel);

		//Decrease foodLevel by 1
		de();

		//Checking the foodLevel and add or remove capabilities respectively
		hunger(this, map, display);

		//After 20 turns of being unconscious, dinosaur will die
		if (hasCapability(DinosaurCapability.UNCONSCIOUS)) {
			turn ++;
			if (turn == 20) {
				addCapability(DinosaurCapability.DEAD);
				display.println("Stegosaur at (" + map.locationOf(this).x() + ", " + map.locationOf(this).y() + ") is dead");
				map.removeActor(this);
			}
		}

		if (isPregnant()) {
			period ++;
			if (period == 10) {
				map.locationOf(this).addItem(new DinosaurEgg("baby"));
				setPregnant(false);
			}
		}

		for (Behaviour behaviour : behaviours) {
			if (behaviour.getAction(this, map) != null)
				return behaviour.getAction(this, map);
		}
		return new DoNothingAction();
		}


}
