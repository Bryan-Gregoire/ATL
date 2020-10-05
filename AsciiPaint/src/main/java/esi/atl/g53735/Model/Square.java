package esi.atl.g53735.Model;

/**
 * Represent a square.
 *
 * @author g53735
 */
public class Square extends Rectangle {

    /**
     * The constructor of Square.
     * 
     * @param upperLeft The position of the square.
     * @param side the length of the sides.
     * @param color the color of the shape
     */
    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

    /**
     * String represent the Square.
     * 
     * @return the string. 
     */
    @Override
    public String toString() {
        return "square";
    }  
}
