package esi.atl.g53735.Main;

import esi.atl.g53735.Controller.Application;
import esi.atl.g53735.Model.AsciiPaint;
import esi.atl.g53735.View.View;
import java.util.Scanner;

/**
 *
 * @author g53735
 */
public class Main {
    
     public static void main(String[] args) {
        Application application = new Application(new AsciiPaint(),new View());
        application.start();
    }
}
