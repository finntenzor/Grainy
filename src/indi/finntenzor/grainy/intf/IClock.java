package indi.finntenzor.grainy.intf;

/**
 * Clock interface. A clock can return a game inner time.
 * 
 * @author FinnTenzor
 *
 */
public interface IClock {
	/**
	 * @return The time inner the game.
	 */
	long clock();
}
