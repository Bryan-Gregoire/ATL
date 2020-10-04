package esi.atl.g53735.Model;



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