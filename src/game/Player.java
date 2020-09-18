package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

/**
 * Class representing the Player.
 */
public class Player extends Actor {

	private Menu menu = new Menu();
	private Behaviour[] behaviours = {new HarvestGrassBehaviour()};

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
	}


	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		for (Behaviour behaviour : behaviours) {
			Action action = behaviour.getAction(this, map);
			if (action != null) {
				return action;
			}
			if (lastAction.getNextAction() != null) {
				return lastAction.getNextAction();

			}

		}
		return menu.showMenu(this, actions, display);
	}
}
