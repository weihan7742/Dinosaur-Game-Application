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
		boolean end = false;
		// Check horizontally
		while (!end){
			for (int i = 1; i < 3; i++) {
				if (currentLocation.x() - i >= 0 && currentLocation.x() + i < currentLocation.map().getXRange().max()) {
					if (currentLocation.map().at(currentLocation.x()+i, currentLocation.y()).getDisplayChar() == '^' ||
							currentLocation.map().at(currentLocation.x()-i,currentLocation.y()).getDisplayChar() == '^') {
						if (probability.calculateProbability(5)) {
							Grass grass = new Grass();
							currentLocation.setGround(grass);
							grass.addEcoPoint();
							end = true;
						}
					}
				}
			}
			if(end){
				break;
			}

			for (int i = 1; i < 3; i++) {
				if (currentLocation.y() - i >= 0 && currentLocation.y() + i < currentLocation.map().getYRange().max()) {
					if (currentLocation.map().at(currentLocation.x(), currentLocation.y()+i).getDisplayChar() == '^' ||
							currentLocation.map().at(currentLocation.x(),currentLocation.y()-i).getDisplayChar() == '^') {
						if (probability.calculateProbability(5)) {
							Grass grass = new Grass();
							currentLocation.setGround(grass);
							grass.addEcoPoint();
							end = true;
						}
					}
				}
			}

			if(end){
				break;
			}

			if (currentLocation.y()-1 >= 0 && currentLocation.y()+1 < currentLocation.map().getYRange().max()){
				char yUp = currentLocation.map().at(currentLocation.x(), currentLocation.y()+1).getDisplayChar();
				char yDown = currentLocation.map().at(currentLocation.x(),currentLocation.y()-1).getDisplayChar();
				if (yUp == '+' || yUp == 't' || yUp == 'T' || yDown == '+' || yDown == 't' || yDown == 'T') {
					if (probability.calculateProbability(5)){
						Grass grass = new Grass();
						currentLocation.setGround(grass);
						grass.addEcoPoint();
						break;
					}
				}
			}

			if (currentLocation.x()-1 >= 0 && currentLocation.x()+1 < currentLocation.map().getXRange().max()){
				char xUp = currentLocation.map().at(currentLocation.x()+1, currentLocation.y()).getDisplayChar();
				char xDown = currentLocation.map().at(currentLocation.x()-1,currentLocation.y()).getDisplayChar();
				if (xUp == '+' || xUp == 't' || xUp == 'T' || xDown == '+' || xDown == 't' || xDown == 'T') {
					if (probability.calculateProbability(5)){
						Grass grass = new Grass();
						currentLocation.setGround(grass);
						grass.addEcoPoint();
						break;
					}
				}
			}
			end = true;
		}
	}

}