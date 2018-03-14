package indi.finntenzor.grainy.util;

import indi.finntenzor.grainy.intf.IClock;

/**
 * A simple clock for java platforms. Use System.currentTimeMillis() to
 * calculate time.
 * 
 * @author FinnTenzor
 *
 */
public class JavaClock implements IClock {
	// the time between pause() and resume().
	private long gap;

	// last pause() time.
	private long last;

	/**
	 * Construct a java clock with time is zero.
	 */
	public JavaClock() {
		reset();
	}

	/**
	 * Reset time to zero.
	 */
	public void reset() {
		gap = System.currentTimeMillis();
		last = System.currentTimeMillis();
	}

	@Override
	public long clock() {
		return System.currentTimeMillis() - gap;
	}

	/**
	 * Pause timing.
	 */
	public void pause() {
		last = System.currentTimeMillis();
	}

	/**
	 * Resume timing.
	 */
	public void resume() {
		gap += System.currentTimeMillis() - last;
	}
}
