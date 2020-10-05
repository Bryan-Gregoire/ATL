package esi.atl.g53735.View;

/**
 * Represent the view of the application.
 * 
 * @author g53735
 */
public class View implements InterfaceView {

    /**
     * Display the given message.
     * 
     * @param message 
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    /**
     * Display all illustrations.
     * 
     * @param shape the illustrations.
     */
    @Override
    public void displayShape(String shape) {
        System.out.println(shape);
    }

}
