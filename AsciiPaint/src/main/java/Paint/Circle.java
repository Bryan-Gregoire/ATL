package Paint;

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
        return this.center.equals(p);
    }
    
}
