package esi.atl.g53735.Model;

/**
 *
 * @author g53735
 */
public abstract class ColoredShape implements Shape {

    private char color;

    public ColoredShape(char color) {
        this.color = color;
    }

    @Override
    public char getColor() {
        return this.color;
    }

    public void setColor(char color) {
        this.color = color;
    }
}
