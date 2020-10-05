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

    /**
     * Constructor of Drawing.
     * 
     */
    public Drawing() {
        this.height = 40;
        this.width = 40;
        this.shapes = new ArrayList<>();
    }

    /**
     * Constructor of Drawing.
     * 
     * @param height the height.
     * @param width the width.
     */
    public Drawing(int height, int width) {
        this.height = height;
        this.width = width;
        this.shapes = new ArrayList<>();
    }

    /**
     * Get the height.
     * 
     * @return the height.
     */
    int getHeight() {
        return height;
    }

    /**
     * Get the width.
     * 
     * @return the width. 
     */
    int getWidth() {
        return width;
    }

    /**
     * Add the given shape.
     * 
     * @param shape the given shape to add.
     */
    public void addShape(Shape shape) {
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
