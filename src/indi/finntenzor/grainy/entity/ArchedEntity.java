package indi.finntenzor.grainy.entity;

import indi.finntenzor.grainy.intf.IEntity;

/**
 * A ArchedEntity contains a circle collision case in the center and a rectangle
 * collision case called arm. It has its own origin point. The center of the
 * circle is overlapped with the origin point. One side of the rectangle arm is
 * cross the origin point. The inner size are relative and origin point
 * positions are absolute.
 * 
 * @author FinnTenzor
 *
 */
public class ArchedEntity extends Entity {
    public final static int LEFT = 0;
    public final static int RIGHT = 1;
    public final static int UP = 2;
    public final static int DOWN = 3;

    // The origin point.
    private final Point originPoint;

    // The inner circle.
    private final RoundEntity circle;

    // The inner rectangle.
    private final RectEntity rect;

    /**
     * Construct a ArchedEntity with given origin point.
     * 
     * @param origin The origin point.
     * @param radius The arch radius.
     * @param length The arm length.
     * @param direct The direction of arm.
     */
    /* package */ ArchedEntity(Point origin, float radius, float length, int direct) {
        this.originPoint = origin;
        circle = new RoundEntity(origin, 0, 0, radius);
        switch (direct) {
        case LEFT:
            rect = new RectEntity(origin, -length, -radius / 2, 0, radius / 2);
            break;
        case RIGHT:
            rect = new RectEntity(origin, 0, -radius / 2, length, radius / 2);
            break;
        case UP:
            rect = new RectEntity(origin, -radius / 2, -length, radius / 2, 0);
            break;
        case DOWN:
        default:
            rect = new RectEntity(origin, -radius / 2, 0, radius / 2, length);
            break;
        }
    }

    /**
     * Construct a ArchedEntity.
     * 
     * @param radius The arch radius.
     * @param length The arm length.
     * @param direct The direction of arm.
     */
    public ArchedEntity(float radius, float length, int direct) {
        this(new Point(), radius, length, direct);
    }

    @Override
    protected boolean checkCollide(IEntity obj) throws UncheckableException {
        if (obj instanceof ArchedEntity) {
            ArchedEntity ae = (ArchedEntity) obj;
            return ae.circle.isCollide(circle) || ae.circle.isCollide(rect) || ae.rect.isCollide(circle)
                    || ae.rect.isCollide(rect);
        } else if (obj instanceof RoundEntity || obj instanceof RectEntity) {
            return obj.isCollide(circle) || obj.isCollide(rect);
        }
        throw Uncheckable;
    }

    @Override
    public Point getOriginPoint() {
        return originPoint;
    }

    @Override
    public void onDraw(Object canvas) {

    }

    @Override
    public void onMove() {

    }
}
