package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * A child class of Ground which represents tree which is a type of terrain in the game.
 */
public class Tree extends Ground {

	private int age = 0;
	private Item fruit = new Fruit();

	/**
	 * Constructor.
	 */
	public Tree() {
		super('+');
	}

	@Override
	public void tick(Location location) {
		super.tick(location);
		Probability probability = new Probability();

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';

		if (location.getDisplayChar() != fruit.getDisplayChar() && probability.calculateProbability(5)) {
			location.addItem(fruit);
		}
	}
}
