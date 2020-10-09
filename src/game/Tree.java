package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Tree extends Ground {
	private int age = 0;
	private Item fruit = new Fruit();

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

		if (probability.calculateProbability(5)) {
			location.addItem(fruit);
		}
	}
}
