package Paint;



/**
 * Represent the shape and defines the behaviors expected by 
 * any shape.
 * 
 * @author g53735
 */
public interface Shape {
    
    void move(double dx, double dy);
    
    boolean isInside(Point p); 
    
    char getColor();
        
}