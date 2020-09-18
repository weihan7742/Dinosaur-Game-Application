package game;

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

	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);

		for (int i = 1; i < 3; i++) {
			if (currentLocation.x() - i >= 0 && currentLocation.x() + i < currentLocation.map().getXRange().max()) {

				if (currentLocation.map().at(currentLocation.x()+i, currentLocation.y()).getDisplayChar() == '^' ||
						currentLocation.map().at(currentLocation.x()-i,currentLocation.y()).getDisplayChar() == '^') {
					if (probability.calculateProbability(10)) {
						currentLocation.setGround(new Grass());
					}
				}
			}
		}

		if (currentLocation.y()-1 >= 0 && currentLocation.y()+1 < currentLocation.map().getYRange().max()){
			Location yUp = new Location(currentLocation.map(),currentLocation.x(), currentLocation.y()+1);
			Location yDown = new Location(currentLocation.map(),currentLocation.x(), currentLocation.y()-1);

			if (currentLocation.map().at(currentLocation.x(), currentLocation.y()+1).getDisplayChar() == '^' ||
					currentLocation.map().at(currentLocation.x(),currentLocation.y()-1).getDisplayChar() == '^') {
				if (probability.calculateProbability(10)){
					currentLocation.setGround(new Grass());
				}
			}
		}

	}
}