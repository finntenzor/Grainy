package indi.finntenzor.grainy.entity;

import indi.finntenzor.grainy.intf.IEntity;

/**
 * Exception that implies the collision check is unreasonable or may be
 * reasonable.
 * 
 * @author FinnTenzor
 *
 */
public class UncheckableException extends IllegalArgumentException {
	private final static long serialVersionUID = 8411009257655587631L;

	// Use for entity collide check.
	/* package */ final static UncheckableException EMPTY_INSTANCE;

	/**
	 * Construct a UncheckableException form two Entity.
	 * 
	 * @param a Entity a.
	 * @param b Entity b.
	 */
	public UncheckableException(IEntity a, IEntity b) {
		super(a.getClass().getName() + "&" + b.getClass().getName());
	}

	private UncheckableException() {

	}

	static {
		EMPTY_INSTANCE = new UncheckableException();
	}
}
