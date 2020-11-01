package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements EcoPointInterface {

	private Menu menu = new Menu();
	private Behaviour[] behaviours = {new HarvestGrassBehaviour(), new SearchFruitBehaviour(),
			new FeedingBehaviour(), new BuyingBehaviour()};
	private int currentMoves = 0;
	private int winningMoves = 0;
	private int winningEcoPoints = 0;
	private boolean challengeOrNot = false;


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
	public boolean AttackAbility() {
		return true;
	}

	@Override
	public Action playTurn(Actions actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		for (Behaviour behaviour : behaviours) {
			if (behaviour.getClass() == BuyingBehaviour.class) {
				if (((BuyingBehaviour) behaviour).getMoreActions(this,map) != null) {
					for (Action moreActions : ((BuyingBehaviour) behaviour).getMoreActions(this,map)) {
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
		actions.add(new EndGameAction());
		display.println("Player currently has " + ecoPoint.getEcoPoint() + " points.");
		if(challengeOrNot){
			// Game end
			if(checkMoves()){
				// Check for winning
				if(checkWinning()){
					display.println("Player has won.");
				}
				else{
					display.println("Player has lost");
				}
				map.removeActor(this);
			}
			addMove();
			display.println("Number of moves: " + currentMoves);
		}
		return menu.showMenu(this, actions, display);
	}

	public void addMove(){
		currentMoves += 1;
	}

	public void setChallengeOrNot(boolean bool){
		challengeOrNot = bool;
	}

	public void setWinningMoves(int winningMoves) {
		this.winningMoves = winningMoves;
	}

	public void setWinningEcoPoints(int winningEcoPoints) {
		this.winningEcoPoints = winningEcoPoints;
	}

	public boolean checkWinning(){
		return ecoPoint.getEcoPoint() > winningEcoPoints;
	}

	public boolean checkMoves(){
		return currentMoves > winningMoves;
	}
}
