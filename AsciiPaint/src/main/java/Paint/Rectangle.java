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

    public Rectangle(Point upperLeft, double height, double width, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
    }

    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    @Override
    public boolean isInside(Point p) {
        return (this.upperLeft.getX() <= p.getX()
                && (this.upperLeft.getX() + this.width) >= p.getX())
                && (this.upperLeft.getY() <= p.getY()
                && ((this.upperLeft.getY() + this.height) >= p.getY()));
    }
}
