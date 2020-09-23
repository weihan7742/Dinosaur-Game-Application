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

	// Put doc
	@Override
	public void tick(Location currentLocation) {
		super.tick(currentLocation);
		for (int i = 1; i < 3; i++) {
			if (currentLocation.x() - i >= 0 && currentLocation.x() + i < currentLocation.map().getXRange().max()) {
				if (currentLocation.map().at(currentLocation.x()+i, currentLocation.y()).getDisplayChar() == '^' ||
						currentLocation.map().at(currentLocation.x()-i,currentLocation.y()).getDisplayChar() == '^') {
					if (probability.calculateProbability(5)) {
						Grass grass = new Grass();
						currentLocation.setGround(grass);
						grass.addEcoPoint();
					}
				}
			}
		}

		if (currentLocation.y()-1 >= 0 && currentLocation.y()+1 < currentLocation.map().getYRange().max()){
			char yUp = currentLocation.map().at(currentLocation.x(), currentLocation.y()+1).getDisplayChar();
			char yDown = currentLocation.map().at(currentLocation.x(),currentLocation.y()-1).getDisplayChar();
			if (yUp == '+' || yUp == 't' || yUp == 'T' || yDown == '+' || yDown == 't' || yDown == 'T') {
				if (probability.calculateProbability(5)){
					Grass grass = new Grass();
					currentLocation.setGround(grass);
					grass.addEcoPoint();
				}
			}
		}
	}
}