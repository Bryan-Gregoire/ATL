package esi.atl.g53735.Model;

/**
 * Represent a circle.
 *
 * @author g53735
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    /**
     * Constructor of Circle.
     *
     * @param center the center of the circle.
     * @param radius the radius of the circle.
     * @param color the color of the circle.
     */
    public Circle(Point center, double radius, char color) {
        super(color);
        //@pbt defensive
        this.center = center;
        this.radius = radius;
    }

    /**
     * Move the circle.
     *
     * @param dx add to the x.
     * @param dy add to the y.
     */
    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    /**
     * Check if the given point is inside.
     *
     * @param p the given point.
     * @return true if is inside, else false.
     */
    @Override
    public boolean isInside(Point p) {
        return Math.sqrt((Math.pow(p.getX() - this.center.getX(), 2))
                + (Math.pow(this.center.getY() - p.getY(), 2))) <= this.radius;
    }

    /**
     * String represent the circle.
     *
     * @return the String.
     */
    @Override
    public String toString() {
        return "circle";
    }
}
