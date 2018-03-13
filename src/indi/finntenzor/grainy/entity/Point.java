package indi.finntenzor.grainy.entity;

import java.util.Locale;

/**
 * A simple 2D point.
 * 
 * @author FinnTenzor
 *
 */
public class Point {
	/**
	 * The x position of this point.
	 */
	public float x;
	/**
	 * The y position of this point.
	 */
	public float y;

	@Override
	public String toString() {
		return String.format(Locale.getDefault(), "{Point x:%f y:%f}", x, y);
	}
}
