package esi.atl.g53735.Model;

import java.util.Scanner;


/**
 *
 * @author g53735
 */
public class AsciiPaint implements Model {

    private Drawing drawing;
    public Scanner keyboard;

    public AsciiPaint() {
        this.drawing = new Drawing();
        this.keyboard = new Scanner(System.in);
    }

    public AsciiPaint(int height, int width) {
        this.drawing = new Drawing(height, width);
        this.keyboard = new Scanner(System.in);
    }

    @Override
    public void newCircle(int x, int y, double radius, char color) {
        drawing.addShapeAt(new Circle(new Point(x, y), radius, color));
    }

    @Override
    public void newRectangle(int x, int y, double height, double width,
            char color) {
        drawing.addShapeAt(new Rectangle(new Point(x, y), height, width,
                color));
    }

    @Override
    public void newSquare(int x, int y, double side, char color) {
        drawing.addShapeAt(new Square(new Point(x, y), side, color));
    }

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
