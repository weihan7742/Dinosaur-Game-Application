package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	/**
	 * Constructor.
	 */
	public Dirt() {
		super('.');
	}

	/**
	 * Every time this method is called, there is a chance for spawning grass.
	 *
	 * @param currentLocation Location of Dirt
	 */
	@Override
	public void tick(Location currentLocation) {
		Probability probability = new Probability();
		super.tick(currentLocation);
		Grass grass = new Grass();
		boolean checked = false;

		for (Exit exit : currentLocation.getExits()) {

			if (checked){
				break;
			}

 			// Check if got tree
			if (exit.getDestination().toString() == new Tree().toString()) {
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

				// Check if got grass
				if (exit1.getDestination().getDisplayChar() == grass.getDisplayChar()) {
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