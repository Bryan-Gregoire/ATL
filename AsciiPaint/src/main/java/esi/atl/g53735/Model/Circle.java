package esi.atl.g53735.Model;

/**
 * Represent a circle.
 *
 * @author g53735
 */
public class Circle extends ColoredShape {

    private Point center;
    private double radius;

    public Circle(Point center, double radius, char color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return Math.sqrt((Math.pow(p.getX() - this.center.getX(), 2))
                + (Math.pow(this.center.getY() - p.getY(), 2))) <= this.radius;
    }

    @Override
    public String toString() {
        return "circle";
    }
}
