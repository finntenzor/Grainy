package indi.finntenzor.grainy.entity;

import indi.finntenzor.grainy.intf.IEntity;

/**
 * A Entity is a object in the game. It can be draw, be move and be delete.
 * Also, it has its origin point and it can check collision between them.
 * 
 * @author FinnTenzor
 *
 */
public abstract class Entity implements IEntity {
	private boolean delete;

	/**
	 * This method will be automatically called when this entity should be draw.
	 * 
	 * @param canvas Canvas on Android or Graphics on PC.
	 */
	public abstract void onDraw(Object canvas);

	/**
	 * This method will be automatically called when this entity should be move form
	 * last frame.
	 */
	public abstract void onMove();

	/**
	 * Mark this entity to be deleted.
	 */
	public void delete() {
		delete = true;
	}

	/**
	 * Check is the entity should be deleted.
	 * 
	 * @return True if delete() is called.
	 */
	public boolean isDeleted() {
		return delete;
	}

	/**
	 * Get the origin point of this Entity.
	 * 
	 * @return The origin point.
	 */
	public abstract Point getOriginPoint();

	/**
	 * Check is two entities collide, returns true or false if they can certainly be
	 * checked.
	 * 
	 * @param obj The object entity.
	 * @return True if collision occurred.
	 * @throws UncheckableException Two entity can't check collision.
	 */
	@Override
	public final boolean isCollide(IEntity obj) throws UncheckableException {
		if (obj instanceof Entity) {
			Entity o = (Entity) obj;
			try {
				return this.checkCollide(o);
			} catch (UncheckableException e1) {
				try {				
					return o.checkCollide(this);
				} catch (UncheckableException e2) {
					throw new UncheckableException(this, obj);
				}
			}
		} else {
			throw new UncheckableException(this, obj);
		}
	}

	/**
	 * Check is two entities collide, returns true or false if they can be checked.
	 * However, may throw UncheckableException when one-way check is not allowed.
	 * 
	 * @param obj The object entity.
	 * @return True if collision occurred.
	 * @throws UncheckableException Throws when can't check by one-way.
	 */
	protected abstract boolean checkCollide(IEntity obj) throws UncheckableException;

	/**
	 * Call this method to throw a UncheckableException in checkCollide to tell
	 * Grainy to check the other way.
	 */
	protected void throwUncheckableException() {
		throw UncheckableException.EMPTY_INSTANCE;
	}
}