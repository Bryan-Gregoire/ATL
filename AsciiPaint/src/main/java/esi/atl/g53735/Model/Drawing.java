package esi.atl.g53735.Model;

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
        this.height = 30;
        this.width = 30;
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

    public Shape getShapeAt(Point p) {
        for (Shape shape : shapes) {
            if (shape.isInside(p)) {
                return shape;
            }
        }
        return null;
    }
}
