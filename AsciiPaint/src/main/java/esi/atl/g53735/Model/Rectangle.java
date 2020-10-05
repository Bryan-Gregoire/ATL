package esi.atl.g53735.Model;

/**
 * Represent the rectangle.
 *
 * @author g53735
 */
public class Rectangle extends ColoredShape {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * Constructor of Rectangle.
     * 
     * @param upperLeft the position of the rectangle.
     * @param height the height of the rectangle.
     * @param width the width of the rectangle.
     * @param color the color of the rectangle.
     */
    public Rectangle(Point upperLeft, double height, double width, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;
    }

    /**
     * Move the rectangle.
     * 
     * @param dx move on the x axis
     * @param dy move on the y axis.
     */
    @Override
    public void move(double dx, double dy) {
        this.upperLeft.move(dx, dy);
    }

    /**
     * Check if shape is inside the board.
     * @param p The given position to check.
     * @return true if is inside, else false.
     */
    @Override
    public boolean isInside(Point p) {
        return (this.upperLeft.getX() <= p.getX()
                && (this.upperLeft.getX() + this.width) >= p.getX())
                && (this.upperLeft.getY() <= p.getY()
                && ((this.upperLeft.getY() + this.height) >= p.getY()));
    }

    /**
     * String represenet the rectangle.
     * 
     * @return the String.
     */
    @Override
    public String toString() {
        return "rectangle";
    }

}
