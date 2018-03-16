package indi.finntenzor.grainy.entity;

import indi.finntenzor.grainy.intf.IEntity;

/**
 * A RoundEntity has a circle collision case and its own origin point. The
 * center of the circle may not overlapped with the origin point. The inner size
 * are relative and origin point positions are absolute.
 * 
 * @author FinnTenzor
 *
 */
public class RoundEntity extends Entity {
    // The origin point.
    private final Point originPoint;

    // The radius of this circle.
    protected float radius;

    // The x distance of the origin point and circle center.
    protected float dx;

    // The y distance of the origin point and circle center.
    protected float dy;

    /**
     * Construct a CircleEntity with given origin point.
     * 
     * @param origin The origin point.
     * @param dx The x distance of the origin point and circle center.
     * @param dy The y distance of the origin point and circle center.
     * @param radius The radius of this circle.
     */
    RoundEntity(Point origin, float dx, float dy, float radius) {
        this.originPoint = origin;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
    }

    @Override
    protected boolean checkCollide(IEntity obj) throws UncheckableException {
        if (obj instanceof RoundEntity) {
            float dx = obj.getOriginPoint().x - originPoint.x;
            float dy = obj.getOriginPoint().y - originPoint.y;
            float r = (float) Math.sqrt(dx * dx + dy * dy);
            return (r < ((RoundEntity) obj).radius + radius);
        }
        throw Uncheckable;
    }

    /**
     * Construct a CircleEntity.
     * 
     * @param dx The x distance of the origin point and circle center.
     * @param dy The y distance of the origin point and circle center.
     * @param radius The radius of this circle.
     */
    public RoundEntity(float dx, float dy, float radius) {
        this(new Point(), dx, dy, radius);
    }

    /**
     * Construct a CircleEntity where the center is overlapped with the origin
     * point.
     * 
     * @param origin The origin point.
     * @param radius The radius of this circle.
     */
    public RoundEntity(float radius) {
        this(0, 0, radius);
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