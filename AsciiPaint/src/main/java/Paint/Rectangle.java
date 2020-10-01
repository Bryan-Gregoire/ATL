package Paint;

/**
 * Represent the rectangle.
 *
 * @author g53735
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    public Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return this.upperLeft.equals(p);
    }
}