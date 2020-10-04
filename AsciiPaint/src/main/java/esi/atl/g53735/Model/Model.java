package esi.atl.g53735.Model;

/**
 *
 * @author g53735
 */
public interface Model {

    public void newCircle(int x, int y, double radius, char color);

    public void newRectangle(int x, int y, double height, double width,
            char color);

    public void newSquare(int x, int y, double side, char color);

    public String asAscii();

}
