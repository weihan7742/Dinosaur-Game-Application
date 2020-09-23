package game;

import edu.monash.fit2099.engine.*;
import edu.monash.fit2099.interfaces.GroundInterface;

import java.util.ArrayList;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements EcoPointInterface {

	private Menu menu = new Menu();
	private Behaviour[] behaviours = {new HarvestGrassBehaviour(), new SearchFruitBehaviour(), new FeedingBehaviour(), new BuyingBehaviour()};

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
			if (behaviour.getClass() == BuyingBehaviour.class){
				if (((BuyingBehaviour) behaviour).getMoreActions(this,map)!= null){
					for (Action moreActions: ((BuyingBehaviour) behaviour).getMoreActions(this,map)){
						actions.add(moreActions);
					}
				}
				continue;
			}
			Action action = behaviour.getAction(this, map);
			if (action != null) {
				actions.add(action);
			}
			if (lastAction.getNextAction() != null) {
				return lastAction.getNextAction();
			}
		}
		System.out.println("Player currently has " + ecoPoint.getEcoPoint() + " points.");
		return menu.showMenu(this, actions, display);
	}
}
