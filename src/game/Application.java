package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

import static game.DinosaurCapability.FEMALE;
import static game.DinosaurCapability.MALE;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	public static void main(String[] args) {
		World world = new World(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree());

		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#_____#....................................................................",
		".....#_____#....................................................................",
		".....###.###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"................................................................................");
		GameMap gameMap = new GameMap(groundFactory, map );
		world.addGameMap(gameMap);
		
		Player player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(9, 4));
		
		// Place a pair of stegosaurs in the middle of the map
		gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur", MALE));
		gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur", FEMALE));

		// Place a vending machine in the map
		gameMap.at(9,4).setGround(new VendingMachine());

		// Place grass initially
		Probability probability = new Probability();
		for(int i: gameMap.getYRange()){
			for(int j: gameMap.getXRange()){
				if(gameMap.at(j,i).getDisplayChar() == '.') {
					if(probability.calculateProbability(2)) {
						Grass grass = new Grass();
						gameMap.at(j,i).setGround(grass);
						grass.addEcoPoint();
					}
				}
			}
		}
		world.run();
	}
}
