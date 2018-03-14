package indi.finntenzor.grainy.entity;

import indi.finntenzor.grainy.intf.IEntity;

/**
 * A RectEntity has a rectangle collision case and its own origin point. The
 * center of the rectangle may not overlapped with the origin point. The inner
 * size are relative and origin point positions are absolute.
 * 
 * @author FinnTenzor
 *
 */
public class RectEntity extends Entity {
	// The origin point.
	private final Point originPoint;

	// The left position of this rectangle.
	protected float x1;

	// The top position of this rectangle.
	protected float y1;

	// The right position of this rectangle.
	protected float x2;

	// The bottom position of this rectangle.
	protected float y2;

	/**
	 * Construct a RectEntity with given origin point.
	 * 
	 * @param origin The origin point.
	 * @param x1 The left position of this rectangle.
	 * @param y1 The top position of this rectangle.
	 * @param x2 The right position of this rectangle.
	 * @param y2 The bottom position of this rectangle.
	 */
	/* package */ RectEntity(Point origin, float x1, float y1, float x2, float y2) {
		this.originPoint = origin;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	@Override
	protected boolean checkCollide(IEntity obj) throws UncheckableException {
		if (obj instanceof RoundEntity) {
			RoundEntity re = (RoundEntity) obj;
			float xa = re.getOriginPoint().x;
			float ya = re.getOriginPoint().y;
			float xb = originPoint.x;
			float yb = originPoint.y;
			return (xa > xb + x1 - re.radius && xa < xb + x2 + re.radius && ya > yb + y1 - re.radius
					&& ya < yb + y2 + re.radius);
		} else if (obj instanceof RectEntity) {
			RectEntity re = (RectEntity) obj;
			float xa = re.getOriginPoint().x;
			float ya = re.getOriginPoint().y;
			float xb = originPoint.x;
			float yb = originPoint.y;
			float left = Math.max(xa + x1, xb + x1);
			float right = Math.min(xa + x2, xb + x2);
			float top = Math.max(ya + y1, yb + y1);
			float bottom = Math.min(ya + y2, yb + y2);
			return (left < right && top < bottom);
		}
		throw Uncheckable;
	}

	/**
	 * Construct a RectEntity.
	 * 
	 * @param x1 The left position of this rectangle.
	 * @param y1 The bottom position of this rectangle.
	 * @param x2 The right position of this rectangle.
	 * @param y2 The top position of this rectangle.
	 */
	public RectEntity(float x1, float y1, float x2, float y2) {
		this(new Point(), x1, y1, x2, y2);
	}

	/**
	 * Construct a RectEntity where the center is overlapped with the origin point.
	 * 
	 * @param origin The origin point.
	 * @param width The width of this rectangle.
	 * @param height The height of this rectangle.
	 */
	public RectEntity(float width, float height) {
		this(-width / 2, -height / 2, width / 2, height / 2);
	}

	@Override
	public void onDraw(Object canvas) {

	}

	@Override
	public void onMove() {

	}

	@Override
	public Point getOriginPoint() {
		return originPoint;
	}

}
