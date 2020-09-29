package Paint;

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

    public Drawing(int height, int weight, List<Shape> shapes) {
        this.height = height;
        this.weight = weight;
        this.shapes = shapes;
    }

    public void drawing() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                for (Shape shape : shapes) {
                    if (shape.isInside(new Point(i, j))) {

                    }
                }
            }
        }
    }

}
