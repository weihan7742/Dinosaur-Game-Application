package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	private Probability probability = new Probability();

	public Dirt() {
		super('.');
	}

	// Put doc
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		Grass grass = new Grass();

		for (Exit exit : currentLocation.getExits()) {
			char current = exit.getDestination().getDisplayChar();
			// Check if got tree
			if (current == '+' || current == 't' || current == 'T') {
				if (probability.calculateProbability(1)) {
					currentLocation.setGround(grass);
					grass.addEcoPoint();
				}
			}
			for (Exit exit1 : exit.getDestination().getExits()) {
				char currentTwo = exit1.getDestination().getDisplayChar();
				// Check if got grass
				if (currentTwo == '^') {
					if (probability.calculateProbability(2)) {
						currentLocation.setGround(grass);
						grass.addEcoPoint();
					}
				}
			}
		}
	}
}