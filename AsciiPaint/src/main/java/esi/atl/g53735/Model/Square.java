package esi.atl.g53735.Model;

/**
 * Represent a square.
 *
 * @author g53735
 */
public class Square extends Rectangle {

    public Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

    @Override
    public String toString() {
        return "square";
    }  
}
