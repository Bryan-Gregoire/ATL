package Paint;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent an illustration.
 *
 * @author g53735
 */
public class Drawing {

    private final List<Shape> shapes;
    private final int height;
    private final int width;

    public Drawing(int height, int width) {
        this.height = height;
        this.width = width;
        this.shapes = new ArrayList<>();
    }

    public Drawing() {
        this.height = 50;
        this.width = 50;
        this.shapes = new ArrayList<>();
    }

    int getHeight() {
        return height;
    }

    int getWidth() {
        return width;
    }

    public void addShapeAt(Shape shape) {
        this.shapes.add(shape);
    }

    public Shape getShape(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }

}
