package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	private Probability probability = new Probability();

	/**
	 * Constructor.
	 */
	public Dirt() {
		super('.');
	}

	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		Grass grass = new Grass();
		boolean checked = false;

		for (Exit exit : currentLocation.getExits()) {

			if (checked){
				break;
			}

			char current = exit.getDestination().getDisplayChar();
 			// Check if got tree
			if (current == '+' || current == 't' || current == 'T') {
				checked = true;
				if (probability.calculateProbability(1)) {
					currentLocation.setGround(grass);
					grass.addEcoPoint();
					break;
				}
			}

			for (Exit exit1 : exit.getDestination().getExits()) {

				if (checked){
					break;
				}

				char currentTwo = exit1.getDestination().getDisplayChar();
				// Check if got grass
				if (currentTwo == '^') {
					checked = true;
					if (probability.calculateProbability(2)) {
						currentLocation.setGround(grass);
						grass.addEcoPoint();
						break;
					}
				}
			}
		}
	}
}