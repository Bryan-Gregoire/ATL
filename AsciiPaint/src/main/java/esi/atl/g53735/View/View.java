package esi.atl.g53735.View;

import esi.atl.g53735.Model.Shape;
import java.util.Scanner;

/**
 *
 * @author g53735
 */
public class View implements InterfaceView {

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
    
    @Override
    public void displayShape(String shape) {
        System.out.println(shape);
    }

}
