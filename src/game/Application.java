package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.*;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	public static void main(String[] args) {
		Probability probability = new Probability();

		List<String> map = Arrays.asList(
				"................................................................................",
				"................................................................................",
				".....#######....................................................................",
				".....#_____#....................................................................",
				".....#_____#....................................................................",
				".....###_###........................~~~~~~......................................",
				"................................................................................",
				"......................................+++.......................................",
				".......................................++++..........~~~~~~.....................",
				"...............~~~~~~..............+++++........................................",
				".....................................++++++.....................................",
				"......................................+++.......................................",
				".....................................+++........................................",
				"................................................................................",
				"............+++............~~~~~~...............................................",
				".............+++++..............................................................",
				"...............++........................................+++++..................",
				".............+++...............~~~~~~...............++++++++....................",
				"............+++................~~~~~~.................+++.......................",
				"...............................~~~~~~...........................................",
				"...............................~~~~~~....................................++.....",
				"........................................................................++.++...",
				".........................................................................++++...",
				"..........................................................................++....",
				"................................................................................");

		// New map for the game
		List<String> newMap = Arrays.asList(
				"................................................................................",
				"................................................................................",
				".........................................................~~~~~~~................",
				".....................~~~~~~.....................................................",
				"................................................................................",
				"................................................................................",
				"..................................................+.........+...................",
				"......................~~~~~~.......................+.......+....................",
				"....................................................+.....+.....................",
				".....................................................+++++......................",
				"........................+...........................+.....+.....................",
				"........................+..........................+.......+....................",
				"........................+.........................+.........+...................",
				"........................+.......................................................",
				".....................+++++++....................................................",
				"........................+.......................................................",
				"........................+.......................................................",
				"........................+.......................................................",
				"........................+.........................~~~~~~~.......................",
				"........................+.......................................................",
				"...........................########.............................................",
				"...........................#~~~~~~#.............................................",
				"..............................................................+++++.............",
				"................................................................................",
				"................................................................................");

		Player player = new Player("Player", '@', 100);

		int gameNumber;
		int endGameNumber = -1; // Quitting game always have -1 return
		while (true) {
			World world = new World(new Display());
			FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(),new Water());

			gameNumber = setMode(player);
			if (gameNumber == endGameNumber) {
				break;
			}
			// Reset player
			player = new Player("Player", '@', 100);

			// Add game map (old)
			GameMap gameMap = new GameMap(groundFactory, map);
			world.addGameMap(gameMap);

			// Add game map (new)
			GameMap newGameMap = new GameMap(groundFactory,newMap);
			world.addGameMap(newGameMap);

			// Add player
			world.addPlayer(player, gameMap.at(9, 4));

			// Allows player to move from old map to new map
			int gameMapNorth = gameMap.getYRange().min();
			int newGameMapSouth = newGameMap.getYRange().max();
			boolean displayOnMenu;
			// Set border to allow player to move across maps
			for (int i=0; i<gameMap.getXRange().max()+1; i++) { //
				displayOnMenu = i % 3 == 0;
				// Old Map
				Border borderOld = new Border(newGameMap.at(i,newGameMapSouth-1),"to new map",displayOnMenu);
				gameMap.at(i,gameMapNorth).setGround(borderOld);

				// New Map
				Border borderNew = new Border(gameMap.at(i,gameMapNorth+1), "to old map", displayOnMenu);
				newGameMap.at(i,newGameMapSouth).setGround(borderNew);
			}

			// Place a pair of stegosaurs in the middle of the map
			gameMap.at(30, 12).addActor(new Stegosaur("Male Stegosaur", true));
			gameMap.at(32, 12).addActor(new Stegosaur("Female Stegosaur", false));
			newGameMap.at(5,15).addActor(new Stegosaur("Male Stegosaur", true));
			newGameMap.at(7,15).addActor(new Stegosaur("Female Stegosaur",false));

			// Place a vending machine in the map
			gameMap.at(9,4).setGround(new VendingMachine());
			newGameMap.at(9,15).setGround(new VendingMachine());

			// Place grass initially
			ArrayList<GameMap> gameMaps = new ArrayList<>();
			gameMaps.add(gameMap);
			gameMaps.add(newGameMap);
			for (GameMap currentMap : gameMaps) {
				for (int i : currentMap.getYRange()) {
					for (int j : currentMap.getXRange()) {
						if (currentMap.at(j, i).getDisplayChar() == '.') {
							if (probability.calculateProbability(2)) {
								Grass grass = new Grass();
								currentMap.at(j, i).setGround(grass);
								grass.addEcoPoint();
							}
						}
					}
				}
			}

			world.run();
		}
	}

	/**
	 * Allow user to set game mode
	 *
	 * @param player Player playing
	 * @return number representing game mode
	 */
	public static int setMode(Player player){
		ModeDisplay modeDisplay = new ModeDisplay();
		int userInput = modeDisplay.chooseMode(player);

		switch(userInput){
			case 1:
				player.setChallengeOrNot(true);
				int moves = modeDisplay.inputNumber("Enter number of moves: ",false);
				int points = modeDisplay.inputNumber("Enter number of points: ",false);
				player.setWinningMoves(moves);
				player.setWinningEcoPoints(points);
				break;

			case 2:
				player.setChallengeOrNot(false);
				break;

			case 3: // Quit
				return -1;
		}
		return userInput;
	}
}
