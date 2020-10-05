package esi.atl.g53735.Model;

/**
 *
 * @author g53735
 */
public class AsciiPaint implements Model {

    private Drawing drawing;

    /**
     * Constructor of AsciiPaint.
     *
     */
    public AsciiPaint() {
        this.drawing = new Drawing();
    }

    /**
     * Constructor of AsciiPaint.
     *
     * @param height the given height.
     * @param width the given width.
     */
    public AsciiPaint(int height, int width) {
        this.drawing = new Drawing(height, width);
    }

    /**
     * Add the circle.
     *
     * @param x the x of the center of the circle.
     * @param y the y of the center of the circle.
     * @param radius the radius of the circle.
     * @param color the color of the circle.
     */
    @Override
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    /**
     * Add a rectangle.
     *
     * @param x the x of the upperLeft of the rectangle.
     * @param y the y of the upperLeft of the rectangle.
     * @param height the height of the rectangle.
     * @param width the width of the rectangle.
     * @param color the color of the rectangle.
     */
    @Override
    public void newRectangle(int x, int y, double height, double width,
            char color) {
        drawing.addShape(new Rectangle(new Point(x, y), height, width,
                color));
    }

    /**
     * Add a square.
     *
     * @param x the x of the square.
     * @param y the y of the square.
     * @param side the length of the sides of the square.
     * @param color the color of the square.
     */
    @Override
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShape(new Square(new Point(x, y), side, color));
    }

    /**
     * String represent the Illustrations.
     *
     * @return the String.
     */
    @Override
    public String asAscii() {
        String draw = "";
        for (int i = 0; i < drawing.getHeight(); i++) {
            for (int j = 0; j < drawing.getWidth(); j++) {
                Shape shape = drawing.getShapeAt(new Point(i, j));
                if (shape == null) {
                    draw += " ";
                } else {
                    draw += shape.getColor();
                }
            }
            draw += "\n";
        }
        return draw;
    }
}
