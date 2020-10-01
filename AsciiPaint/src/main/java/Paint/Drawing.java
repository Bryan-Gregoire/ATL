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
    private final int weight;

    public Drawing(int height, int weight) {
        this.height = height;
        this.weight = weight;
        this.shapes = new ArrayList<>();
    }

    public Drawing() {
        this.height = 0;
        this.weight = 0;
        this.shapes = new ArrayList<>();
    }

    int getHeight() {
        return height;
    }

    int getWeight() {
        return weight;
    }

    public void addShapeAt(Shape shape) {
        this.shapes.add(shape);
    }

    public Shape getShape(Point p) {
        for (Shape shape : shapes) {
            if (shape.equals(p)) {
                return shape;
            }
        }
        return null;
    }

    public void drawing() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
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
