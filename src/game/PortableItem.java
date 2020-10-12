package game;

import edu.monash.fit2099.engine.Item;

/**
 * Base class for any item that can be picked up and dropped.
 */
public class PortableItem extends Item {

	/**
	 * Constructor.
	 *
	 * @param name name of the item
	 * @param displayChar character to be displayed
	 */
	public PortableItem(String name, char displayChar) {
		super(name, displayChar, true);
	}
}
