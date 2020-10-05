package esi.atl.g53735.Main;

import esi.atl.g53735.Controller.Application;
import esi.atl.g53735.View.View;

/**
 *
 * @author g53735
 */
public class Main {
    
     public static void main(String[] args) {
        Application application = new Application(new View());
        application.start();
    }
}
