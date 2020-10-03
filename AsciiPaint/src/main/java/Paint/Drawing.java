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
        this.height = 5;
        this.width = 5;
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

    public void drawing() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                for (Shape shape : shapes) {
                    if (shape.isInside(new Point(i, j))) {
                        System.out.println(shape.getColor());
                    } else {
                        System.out.println(" ");
                    }
                }
            }
            System.out.println("");
        }
    }

}
