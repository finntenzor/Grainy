package indi.finntenzor.grainy.intf;

import indi.finntenzor.grainy.entity.Point;
import indi.finntenzor.grainy.entity.UncheckableException;

/**
 * Entity interface. A Entity is a object in the game. It can be draw, be move and be delete.
 * Also, it has its origin point and it can check collision between them.
 * 
 * @author FinnTenzor
 *
 */
public interface IEntity {
	/**
	 * This method will be automatically called when this entity should be draw.
	 * 
	 * @param canvas Canvas on Android or Graphics on PC.
	 */
	void onDraw(Object canvas);

	/**
	 * This method will be automatically called when this entity should be move form
	 * last frame.
	 */
	void onMove();

	/**
	 * Mark this entity to be deleted.
	 */
	void delete();

	/**
	 * Check is the entity should be deleted.
	 * 
	 * @return True if delete() is called.
	 */
	boolean isDeleted();

	/**
	 * Get the origin point of this Entity.
	 * 
	 * @return The origin point.
	 */
	Point getOriginPoint();

	/**
	 * Check is two entities collide, returns true or false if they can certainly be
	 * checked.
	 * 
	 * @param obj The object entity.
	 * @return True if collision occurred.
	 * @throws UncheckableException Two entity can't check collision.
	 */
	boolean isCollide(IEntity obj) throws UncheckableException;
}