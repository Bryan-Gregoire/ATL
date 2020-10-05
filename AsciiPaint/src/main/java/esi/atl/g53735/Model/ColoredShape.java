package esi.atl.g53735.Model;

/**
 * Represenet the Color of the shape.
 * 
 * @author g53735
 */
public abstract class ColoredShape implements Shape {

    private char color;

    /**
     * Constructor of ColoredShape.
     * 
     * @param color the given color.
     */
    public ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Get the color.
     * 
     * @return the color.
     */
    @Override
    public char getColor() {
        return this.color;
    }

    /**
     * Set a color.
     * 
     * @param color the color to set.
     */
    public void setColor(char color) {
        this.color = color;
    }
}
