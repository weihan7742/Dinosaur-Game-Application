package game;

import edu.monash.fit2099.engine.*;

/**
 * Class representing the Player.
 */
public class Player extends Actor implements EcoPointInterface {

	private Menu menu = new Menu();
	private Behaviour[] behaviours = {new HarvestGrassBehaviour(), new SearchFruitBehaviour(),
			new FeedingBehaviour(), new BuyingBehaviour()};
	private int currentMoves = -1;
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
			addMove();
			display.println("Number of moves: " + currentMoves);
			// Check if current points exceeding winning points
			if(checkWinning()){
				return endChallenge(display,"Player has won",map);
			}
			// Check if current moves exceeded moves set
			else if (checkMoves()){
				return endChallenge(display,"Player has lost",map);
			}
		}
		return menu.showMenu(this, actions, display);
	}

	/**
	 * Add move to existing move.
	 */
	public void addMove(){
		currentMoves += 1;
	}

	/**
	 * Set the game to challenge mode or not.
	 *
	 * @param bool true if challenge mode, false otherwise.
	 */
	public void setChallengeOrNot(boolean bool){
		challengeOrNot = bool;
	}

	/**
	 * Set winning moves if it is challenge mode
	 *
	 * @param winningMoves number of moves allowed
	 */
	public void setWinningMoves(int winningMoves) {
		this.winningMoves = winningMoves;
	}

	/**
	 * Set winning eco points if it is challenge mode
	 *
	 * @param winningEcoPoints number of eco points
	 */
	public void setWinningEcoPoints(int winningEcoPoints) {
		this.winningEcoPoints = winningEcoPoints;
	}

	/**
	 * Check if current eco points exceeded to set eco points.
	 *
	 * @return true if exceeded, false otherwise
	 */
	public boolean checkWinning(){
		return ecoPoint.getEcoPoint() > winningEcoPoints;
	}

	/**
	 * Check if current moves exceeded or equal to set moves.
	 *
	 * @return true if exceeded or equal, false otherwise
	 */
	public boolean checkMoves(){
		return currentMoves >= winningMoves;
	}

	/**
	 * End challenge when winning or losing condition is met, or when user chooses to end game.
	 *
	 * @param display I/O input
	 * @param message String to be displayed
	 * @param map Current game map.
	 * @return EndGameAction to end the game
	 */
	public Action endChallenge(Display display, String message, GameMap map){
		display.println(message);
		map.removeActor(this);
		return new EndGameAction();
	}
}
