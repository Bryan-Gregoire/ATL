package Paint;

/**
 *
 * @author Utilisateur
 */
public class AsciPaint {

    private Drawing drawing;

    public AsciPaint() {
        this.drawing = new Drawing();
    }

    public AsciPaint(int height, int width) {
        this.drawing = new Drawing(height, width);
    }

    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShapeAt(new Circle(new Point(x, y), radius, color));
    }

    public void newRectangle(int x, int y, double height, double width,
            char color) {
        drawing.addShapeAt(new Rectangle(new Point(x, y), height, width,
                color));
    }

    public void newSquare(int x, int y, double side, char color) {
        drawing.addShapeAt(new Square(new Point(x, y), side, color));
    }

    public String asAscii() {
        String draw = "";
        for (int i = 0; i < drawing.getHeight(); i++) {
            for (int j = 0; j < drawing.getWidth(); j++) {
                Shape shape = drawing.getShape(new Point(i, j));
                if (shape == null) {
                    draw += " ";
                } else {
                    draw += shape.getColor();
                }
            }
        }
        return draw;
    }
}
