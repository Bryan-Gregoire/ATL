/*
@pbt 

- robustness
what shapes do you want to add? (Rectangles, squares or circles)
A command is written as: add wantedShape positionOfShape (height width Or Radius) colorOfShape
 add circle 4 5 6 
Command not correct, try again: 
add Circle 4 5 6 
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
	at esi.atl.g53735.Controller.Application.addShape(Application.java:127)

- i don't see junit tests
- name or id in project name
- add readme.md file 
*/

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
