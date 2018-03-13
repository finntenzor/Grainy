package indi.finntenzor.grainy.entity;

/**
 * A Entity is a object in the game. It can be draw, be move and be delete.
 * Also, it has its origin point and it can check collision between them.
 * 
 * @author FinnTenzor
 *
 * @param <T> On Android platforms, T should be Canvas. On PC platforms, T
 *            should be Graphics.
 */
public abstract class Entity<T> {
	private boolean delete;

	/**
	 * This method will be automatically called when this entity should be draw.
	 * 
	 * @param canvas Canvas on Android or Graphics on PC.
	 */
	public abstract void onDraw(T canvas);

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
	@SuppressWarnings("rawtypes")
	public final boolean isCollide(Entity obj) throws UncheckableException {
		try {
			return this.checkCollide(obj);
		} catch (UncheckableException e) {
			return obj.checkCollide(this);
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
	@SuppressWarnings("rawtypes")
	protected abstract boolean checkCollide(Entity obj) throws UncheckableException;

	/**
	 * Call this method to throw a UncheckableException in checkCollide to tell
	 * Grainy to check the other way.
	 */
	protected void throwUncheckableException() {
		throw UncheckableException.EMPTY_INSTANCE;
	}
}